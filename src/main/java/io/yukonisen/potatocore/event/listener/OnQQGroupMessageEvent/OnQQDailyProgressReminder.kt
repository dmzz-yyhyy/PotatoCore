package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config
import io.yukonisen.potatocore.util.Config.qqbot
import io.yukonisen.potatocore.util.Config.qqgroup
import me.dreamvoid.miraimc.api.MiraiBot
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.io.File
import java.io.IOException

class OnQQDailyProgressReminder : Listener {
    @EventHandler
    fun inquiryReply(event: MiraiGroupMessageEvent) {
        val group = MiraiBot.getBot(qqbot).getGroup(qqgroup)
        val message = event.message.replace("\\p{C}".toRegex(), "")
        val schedules: FileConfiguration =
            YamlConfiguration.loadConfiguration(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
        var sendMessage: String
        if (message == "查看日程") {
            sendMessage = Config.unfinishedSchedule
            val schedulesList = schedules.getMapList("data")
            for (schedule in schedulesList) {
                val scheduleName = schedule["schedule"] as String?
                var responsible = ""
                for (name in (schedule["responsible"] as List<*>?)!!) {
                    responsible += ", $name"
                }
                responsible = responsible.replaceFirst(", ".toRegex(), "")

                sendMessage += "\n$scheduleName\n      ${Config.responsible}:$responsible"
            }
            group.sendMessageMirai(sendMessage)
        } else if (message.startsWith("添加日程")) {
            if (!((message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray().size == 4) or (message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray().size == 3))) {
                sendMessage = Config.scheduleAddedIncompleteParameters
                group.sendMessage(sendMessage)
                return
            }
            sendMessage = Config.scheduleAddedSuccessfully
            var responsible = ""
            val scheduleName = message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            var warehouse = "null"
            if (message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size == 4) {
                warehouse = message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[3]
            }
            val responsibleList: MutableList<String> = ArrayList()
            for (name in message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()[2].split("\\|".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()) {
                responsibleList.add(name)
                responsible += ", $name"
            }
            responsible = responsible.replaceFirst(", ".toRegex(), "")
            val schedulesDataMap: MutableMap<String, Any> = HashMap()
            schedulesDataMap["schedule"] = scheduleName
            schedulesDataMap["warehouse"] = warehouse
            schedulesDataMap["responsible"] = responsibleList
            val schedulesMapList = schedules.getMapList("data")
            schedulesMapList.add(schedulesDataMap)
            schedules["data"] = schedulesMapList
            try {
                schedules.save(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
            } catch (ignored: IOException) {
            }
            sendMessage += "\n$scheduleName\n      ${Config.responsible}:$responsible"
            group.sendMessage(sendMessage)
        } else if (message.startsWith("修改日程")) {
            if (!((message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray().size == 4) or (message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray().size == 5))) {
                sendMessage =
                    Config.settingScheduleIncompleteParameters
                group.sendMessage(sendMessage)
                return
            }
            sendMessage =
                "${Config.successfullySettingSchedule}  " + message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray()[1]
            var responsible = ""
            val scheduleName = message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[2]
            var warehouse = "null"
            if (message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size == 5) {
                warehouse = message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[4]
            }
            val responsibleList: MutableList<String> = ArrayList()
            for (name in message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()[3].split("\\|".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray()) {
                responsibleList.add(name)
                responsible += ", $name"
            }
            responsible = responsible.replaceFirst(", ".toRegex(), "")
            val schedulesDataMap: MutableMap<String, Any> = HashMap()
            schedulesDataMap["schedule"] = scheduleName
            schedulesDataMap["warehouse"] = warehouse
            schedulesDataMap["responsible"] = responsibleList
            val schedulesMapList = schedules.getMapList("data")
            var originalSchedulesNameIndex = -1
            var i = 0
            while (i < schedulesMapList.size) {
                if (schedulesMapList[i]["schedule"].toString() == message.split(" ".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()[1]
                ) {
                    originalSchedulesNameIndex = i
                }
                i++
            }
            if (originalSchedulesNameIndex == -1) {
                sendMessage = Config.settingScheduleError
                group.sendMessage(sendMessage)
                return
            }
            schedulesMapList[originalSchedulesNameIndex] = schedulesDataMap
            schedules["data"] = schedulesMapList
            try {
                schedules.save(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
            } catch (ignored: IOException) {
            }
            sendMessage =
                "$sendMessage\n$scheduleName\n      ${Config.responsible}:$responsible"
            group.sendMessage(sendMessage)
        } else if (message.startsWith("完成日程")) {
            if (message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().size != 2) {
                sendMessage = Config.completeScheduleIncompleteParameters
                group.sendMessage(sendMessage)
                return
            }
            sendMessage = Config.successfullyCompleteProgram
            var responsible = ""
            val schedulesList = schedules.getMapList("data")
            for (schedule in schedulesList) {
                for (name in (schedule["responsible"] as List<*>?)!!) {
                    responsible += ", $name"
                }
            }
            responsible = responsible.replaceFirst(", ".toRegex(), "")
            val scheduleName = message.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            val schedulesMapList = schedules.getMapList("data")
            var originalSchedulesNameIndex = -1
            var i = 0
            while (i < schedulesMapList.size) {
                if (schedulesMapList[i]["schedule"].toString() == message.split(" ".toRegex())
                        .dropLastWhile { it.isEmpty() }
                        .toTypedArray()[1]
                ) {
                    originalSchedulesNameIndex = i
                }
                i++
            }
            if (originalSchedulesNameIndex == -1) {
                sendMessage = Config.completeScheduleError
                group.sendMessage(sendMessage)
                return
            }
            schedulesMapList.removeAt(originalSchedulesNameIndex)
            schedules["data"] = schedulesMapList
            try {
                schedules.save(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
            } catch (ignored: IOException) {
            }
            sendMessage += "\n$scheduleName\n      ${Config.responsible}:$responsible\n恭喜!"
            group.sendMessage(sendMessage)
        }
    }
}