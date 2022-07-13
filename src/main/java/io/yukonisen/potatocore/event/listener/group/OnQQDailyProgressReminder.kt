package io.yukonisen.potatocore.event.listener.group

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.dailyprogressreminder.DailyProgressReminder
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class OnQQDailyProgressReminder : Listener {
    @EventHandler
    fun inquiryReply(event: MiraiGroupMessageEvent) {
        val message = event.message.replace("\\p{C}".toRegex(), "")
        if (message == "查看日程") {
            PotatoCore.getGroup().sendMessage(DailyProgressReminder.checkSchedule())
        } else if (message.startsWith("添加日程")) {
            PotatoCore.getGroup().sendMessage(DailyProgressReminder.addSchedule(message.split(" ")))
        } else if (message.startsWith("修改日程")) {
            PotatoCore.getGroup().sendMessage(DailyProgressReminder.setSchedule(message.split(" ")))
        } else if (message.startsWith("完成日程")) {
            PotatoCore.getGroup().sendMessage(DailyProgressReminder.completeSchedule(message.split(" ")))
        }
    }
}