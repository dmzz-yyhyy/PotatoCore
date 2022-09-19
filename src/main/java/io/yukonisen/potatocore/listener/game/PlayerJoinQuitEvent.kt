package io.yukonisen.potatocore.event.listener

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.PotatoCore.getGroup
import io.yukonisen.potatocore.util.Config.broadcastEnabled
import io.yukonisen.potatocore.util.Config.playerJoinMsg
import io.yukonisen.potatocore.util.Config.playerQuitMsg
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class PlayerJoinQuitEvent : Listener {

    @EventHandler
    fun onPlayerJoin(join: PlayerJoinEvent) {
        if (broadcastEnabled && getGroup() != null) {
            val msg = playerJoinMsg.replace("%player%", join.player.name)
            getGroup().sendMessageMirai(msg)
        }
    }

    @EventHandler
    fun onPlayerQuit(quit: PlayerQuitEvent) {
        if (broadcastEnabled && getGroup() != null) {
            val msg = playerQuitMsg.replace("%player%", quit.player.name)
            getGroup().sendMessageMirai(msg)
        }
    }
}