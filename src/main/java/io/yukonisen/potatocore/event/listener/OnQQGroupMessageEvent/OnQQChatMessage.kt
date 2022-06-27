package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent

import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class OnQQChatMessage : Listener {

    /* this will forward all group messages,
    not only the messages that start with "#". */

    @EventHandler
    fun onGroupMessage(event: MiraiGroupMessageEvent) {
        if (event.groupID == Config.qqgroup) {
            val msg = event.message.toString()
            val namecard = event.senderNameCard.toString()
            val qqid = event.senderID.toString()
            val sender = namecard.ifEmpty { qqid }
            Bukkit.broadcastMessage("$sender > $msg")
        }
    }
}