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
        if (msg.startsWith("#") && event.groupID == Config.group.toLong()) {
            val forwardMsg = msg.substring(1)
            var sender = event.senderNameCard
            if (sender == null) {
                sender = event.senderID.toString()
            }
            Bukkit.broadcastMessage("$sender > $forwardMsg")
        }
        if (msg == "!#ping" && event.groupID == Config.group.toLong()) {
            val version = Bukkit.getVersion()
            MiraiBot.getBot(Config.bot).getGroup(Config.group.toLong()).sendMessageMirai("PTB Running, version $version")
        }
    }
}