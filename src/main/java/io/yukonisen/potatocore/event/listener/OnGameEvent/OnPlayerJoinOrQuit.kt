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
    fun onPlayerJoin(join: PlayerJoinEvent) {
        val joinmsg: String = PTBConfig.getString("messages.player.join")
        val id = join.player.name
        val msg = joinmsg.replace("%player%", id)
        MiraiBot.getBot(Config.qqbot).getGroup(Config.qqgroup).sendMessageMirai(msg)
    }

    @EventHandler
    fun onPlayerQuit(quit: PlayerQuitEvent) {
        val quitmsg: String = PTBConfig.getString("messages.player.quit")
        val id = quit.player.name
        val msg = quitmsg.replace("%player%", id)
        MiraiBot.getBot(Config.qqbot).getGroup(Config.qqgroup).sendMessageMirai(msg)
    }
}