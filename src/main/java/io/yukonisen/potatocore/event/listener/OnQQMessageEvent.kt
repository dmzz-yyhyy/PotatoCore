package io.yukonisen.potatocore.event.listener

import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.api.MiraiBot
import me.dreamvoid.miraimc.bukkit.event.MiraiGroupMessageEvent
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class OnQQMessageEvent : Listener {
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
        if (msg == "!#ping" && event.groupID == Config.qqgroup) {
            val version = Bukkit.getVersion()
            MiraiBot.getBot(Config.qqbot).getGroup(Config.qqgroup).sendMessageMirai("PTB running on $version")
        }
    }
}