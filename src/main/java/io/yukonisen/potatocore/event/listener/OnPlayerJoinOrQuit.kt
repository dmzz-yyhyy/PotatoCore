package io.yukonisen.potatocore.event.listener

import io.yukonisen.potatocore.util.Config
import io.yukonisen.potatocore.util.Config.PTBConfig
import me.dreamvoid.miraimc.api.MiraiBot
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class OnPlayerJoinOrQuit : Listener {
    @EventHandler
    fun onPlayerJoin(pljev: PlayerJoinEvent) {
        val id = pljev.player.name
        var joinmsg = PTBConfig.getString("messages.player-jq.format.join")
        joinmsg = joinmsg.replace("%player%", id)
        MiraiBot.getBot(Config.bot).getGroup(Config.group.toLong()).sendMessageMirai(joinmsg)
    }

    @EventHandler
    fun onPlayerQuit(plqev: PlayerQuitEvent) {
        val id = plqev.player.name
        var quitmsg = PTBConfig.getString("messages.player-jq.format.quit")
        quitmsg = quitmsg.replace("%player%", id)
        MiraiBot.getBot(Config.bot).getGroup(Config.group.toLong()).sendMessageMirai(quitmsg)
    }
}