package io.yukonisen.potatocore.event.listener.group

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class GroupMsgListener : Listener {

    @EventHandler
    fun onGroupMessage(event: MiraiGroupMessageEvent) {
        if (event.message.startsWith("#")) {
            if (event.groupID == Config.qqgroup) {
                val msg = event.message.toString().drop(1)
                val namecard = event.senderNameCard.toString()
                val name = event.senderName
                val sender = namecard.ifEmpty { name }
                Bukkit.broadcastMessage("$sender > $msg")
            }
        }
    }
}