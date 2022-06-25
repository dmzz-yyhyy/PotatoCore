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
        var joinmsg: String = PTBConfig.getString("messages.player.join")
        val id = join.player.name
        joinmsg = joinmsg.replace("%player%", id)
        MiraiBot.getBot(Config.qqbot).getGroup(Config.qqgroup).sendMessageMirai(joinmsg)
    }

    @EventHandler
    fun onPlayerQuit(quit: PlayerQuitEvent) {
        var quitmsg: String = PTBConfig.getString("messages.player.quit")
        val id = quit.player.name
        quitmsg = quitmsg.replace("%player%", id)
        MiraiBot.getBot(Config.qqbot).getGroup(Config.qqgroup).sendMessageMirai(quitmsg)
    }
}