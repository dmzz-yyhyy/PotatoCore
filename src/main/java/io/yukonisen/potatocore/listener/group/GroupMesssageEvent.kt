package io.yukonisen.potatocore.event.listener.group

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.bukkit.event.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import java.util.*

class GroupMesssageEvent : Listener {

    @EventHandler
    fun onGroupMessage(event: MiraiGroupMessageEvent) {
        val message = event.message

        if (event.groupID == Config.qqgroup) {
            if (message.startsWith("#")) {
                val msg = event.message.toString().replaceFirst("#", "")
                val namecard = event.senderNameCard.toString()
                //  val qqid = event.senderID.toString()
                val name = event.senderName
                val sender = namecard.ifEmpty { name }
                Bukkit.broadcastMessage("$sender > $msg")
            }
        }
    }
}