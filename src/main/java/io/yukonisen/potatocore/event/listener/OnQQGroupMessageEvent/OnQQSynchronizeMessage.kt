package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent

import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class OnQQSynchronizeMessage : Listener {
    @EventHandler
    fun onGroupMessage(event: MiraiGroupMessageEvent) {
        val msg = event.message
        val namecard = event.senderNameCard
        val qqid = event.senderID.toString()
        if (msg.startsWith("#") && event.groupID == Config.qqgroup) {
            val forwardMsg = msg.substring(1)
            val sender = if (namecard.isNullOrEmpty()) qqid else namecard
            Bukkit.broadcastMessage("$sender > $forwardMsg")
        }
    }
}