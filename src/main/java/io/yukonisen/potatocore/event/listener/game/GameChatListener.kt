package io.yukonisen.potatocore.event.listener.game

import io.yukonisen.potatocore.PotatoCore
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class GameChatListener : Listener {

    @EventHandler
    fun onAsyncGameChat(event: AsyncPlayerChatEvent) {
        if (PotatoCore.getGroup() != null) {
            val msg = event.message
            if (msg.startsWith("#")) {
                val forwardMsg: String = msg.substring(1)
                PotatoCore.getGroup().sendMessageMirai(
                    event.player.displayName + ": " + forwardMsg
                )
            }
        }
    }
}
