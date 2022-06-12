package io.yukonisen.potatocore.event.listener;

import me.dreamvoid.miraimc.api.MiraiBot;
import io.yukonisen.potatocore.util.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.NoSuchElementException;

public class OnPlayerJoinOrQuit implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent pljev) {

        String id = pljev.getPlayer().getName();
        String joinmsg = Config.INSTANCE.getPTBConfig().getString("messages.player-jq.format.join");
        joinmsg = joinmsg.replace("%player%", id);
        try {
            MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai(joinmsg);
        } catch (NoSuchElementException nse) {
            System.out.println("Error occurred while sending message:" + nse);
        }
    }

    @EventHandler
    public void OnPlayerQuit(PlayerQuitEvent plqev) {

        String id = plqev.getPlayer().getName();
        String quitmsg = Config.INSTANCE.getPTBConfig().getString("messages.player-jq.format.quit");
        quitmsg = quitmsg.replace("%player%", id);
        try {
            MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai(quitmsg);
        } catch (NoSuchElementException nse) {
            System.out.println("Error occurred while sending message:" + nse);
        }
    }

}
