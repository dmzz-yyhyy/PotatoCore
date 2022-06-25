package io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent;

import io.yukonisen.potatocore.PotatoCore;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Objects;

public class OnQQMaterialInquiry implements Listener {
    @EventHandler
    public void onGroupCommandMessage(MiraiGroupMessageEvent event) {
        MiraiGroup group = MiraiBot.getBot(Config.INSTANCE.getQqbot()).getGroup(Config.INSTANCE.getQqgroup());
        String message = event.getMessage();
        if (message.equals("!#ping") && event.getGroupID() == Config.INSTANCE.getQqgroup()) {
            String version = Bukkit.getVersion();
            group.sendMessageMirai("PTB running on {version}".replace("{version}", version));
        } else if (event.getGroupID() == Config.INSTANCE.getQqgroup() && Objects.requireNonNull(Config.INSTANCE.getQqop()).contains(Long.toString(event.getSenderID()))) {
            if (message.startsWith("!#")) {
                Bukkit.getScheduler().runTask(PotatoCore.getInstance(), () -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), message.replaceFirst("!#", "")));
            }
        }
    }
}
