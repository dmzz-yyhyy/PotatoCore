package io.yukonisen.potatocore.event.timer

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config
import io.yukonisen.potatocore.util.Lang
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.scheduler.BukkitRunnable
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class GroupTodoRemindTimer : BukkitRunnable() {
    private var isSendMessageLastTime = false
    override fun run() {
        var sendMessage: StringBuilder
        if (PotatoCore.getGroup() == null) {
            return
        }
        val formatter = SimpleDateFormat("HH:mm")
        val date = Date(System.currentTimeMillis())
        if (formatter.format(date).replace("\\p{C}", "") == Config.scheduleTimer && !isSendMessageLastTime) {
            val schedules: FileConfiguration =
                YamlConfiguration.loadConfiguration(File(PotatoCore.getInstance().dataFolder, "data/todolist.yml"))
            sendMessage = StringBuilder(Lang.sendScheduleTimer)
            val schedulesList = schedules.getMapList("data")
            for (schedule in schedulesList) {
                val scheduleName = schedule["schedule"].toString()
                var leaders = ""
                for (name in (schedule["leaders"] as List<*>?)!!) {
                    leaders += name.toString()
                }
                leaders = leaders.replaceFirst(", ".toRegex(), "")
                sendMessage.append("\n{scheduleName}\n      ").append(Lang.leaders).append(":{leaders}\n")
                sendMessage = StringBuilder(
                    sendMessage.toString().replace("{scheduleName}", scheduleName).replace("{leaders}", leaders)
                )
            }
            isSendMessageLastTime = true
            PotatoCore.getGroup().sendMessage(sendMessage.toString())
        }
        if (formatter.format(date) != Config.scheduleTimer && isSendMessageLastTime) {
            isSendMessageLastTime = false
        }
    }

    fun start(delay: Long, time: Long) {
        runTaskTimer(PotatoCore.getInstance(), 20L * delay, time)
    }
}