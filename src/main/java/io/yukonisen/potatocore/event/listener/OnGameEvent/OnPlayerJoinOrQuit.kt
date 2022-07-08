package io.yukonisen.potatocore.event.listener

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config.PTBConfig
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class OnPlayerJoinOrQuit : Listener {

    @EventHandler
    fun onPlayerJoin(join: PlayerJoinEvent) {
        if (PotatoCore.getGroup() != null) {
            val joinmsg: String = PTBConfig.getString("messages.player.join")
            val id = join.player.name
            val msg = joinmsg.replace("%player%", id)
        }
    }

    @EventHandler
    fun onPlayerQuit(quit: PlayerQuitEvent) {
        if (PotatoCore.getGroup() == null) {
            val quitmsg: String = PTBConfig.getString("messages.player.quit")
            val id = quit.player.name
            val msg = quitmsg.replace("%player%", id)
            PotatoCore.getGroup().sendMessageMirai(msg)
        }
    }
}