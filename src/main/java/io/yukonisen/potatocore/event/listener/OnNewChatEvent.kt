package io.yukonisen.potatocore.event.listener;

import io.yukonisen.potatocore.util.Config
import me.dreamvoid.miraimc.api.MiraiBot
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class OnNewChatEvent : Listener {

    @EventHandler
    fun onAsyncGameChat(event: AsyncPlayerChatEvent) {
        val msg = event.message
        if (msg.startsWith("#")){
            val forwardMsg: String = msg.substring(1)
            MiraiBot.getBot(Config.bot).getGroup(Config.group.toLong()).sendMessageMirai(
                event.player.displayName + ": " + forwardMsg
            )
        }
    }
}
