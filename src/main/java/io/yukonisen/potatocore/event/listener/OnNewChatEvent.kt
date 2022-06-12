package io.yukonisen.potatocore.event.listener;

import me.dreamvoid.miraimc.api.MiraiBot;
import io.yukonisen.potatocore.util.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

class OnNewChatEvent : Listener {

    @EventHandler
    fun onAsyncGameChat(event: AsyncPlayerChatEvent) {
        val fwdMsg = event.message
        if (fwdMsg.startsWith("#")){
            fwdMsg.substring(1)
            MiraiBot.getBot(Config.bot).getGroup(Config.group.toLong()).sendMessageMirai(
                event.player.displayName + ":" + fwdMsg
            )
        }
    }
}
