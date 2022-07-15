package io.yukonisen.potatocore.event.listener.group

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.TodoReminder
import io.yukonisen.potatocore.util.Config.qqbot
import io.yukonisen.potatocore.util.Config.qqgroup
import io.yukonisen.potatocore.util.Config.qqop
import me.dreamvoid.miraimc.api.MiraiBot
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.*

class GroupCommandListener : Listener {
    @EventHandler
    fun onGroupCommandMessage(event: MiraiGroupMessageEvent) {
        val group = MiraiBot.getBot(qqbot).getGroup(qqgroup)
        val message = event.message
        if (message == "!#ping" && event.groupID == qqgroup) {
            val version = Bukkit.getVersion()
            group.sendMessageMirai("PTB running on $version")
        }
        if (message.startsWith("!#") && event.groupID == qqgroup &&
            Objects.requireNonNull<List<String>?>(qqop).contains(event.senderID.toString())
        ) {
            Bukkit.getScheduler().runTask(PotatoCore.getInstance()) {
                Bukkit.dispatchCommand(
                    Bukkit.getConsoleSender(),
                    message.replaceFirst("!#".toRegex(), "")
                )
            }
        }
        if (message == "查看日程") {
            PotatoCore.getGroup().sendMessage(TodoReminder.checkTodo())
        }
        if (message.startsWith("添加日程")) {
            PotatoCore.getGroup().sendMessage(TodoReminder.addTodo(message.split(" ")))
        }
        if (message.startsWith("修改日程")) {
            PotatoCore.getGroup().sendMessage(TodoReminder.modifyTodo(message.split(" ")))
        }
        if (message.startsWith("完成日程")) {
            PotatoCore.getGroup().sendMessage(TodoReminder.completeTodo(message.split(" ")))
        }

    }
}
