package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.command.PTBCommand;
import io.yukonisen.potatocore.event.listener.game.GameChatListener;
import io.yukonisen.potatocore.event.listener.PlayerSessionListener;
import io.yukonisen.potatocore.event.listener.group.GroupCommandListener;
import io.yukonisen.potatocore.event.listener.group.GroupMsgListener;
import io.yukonisen.potatocore.event.listener.group.OnQQDailyProgressReminder;
import io.yukonisen.potatocore.event.listener.group.OnQQMaterialInquiry;
import io.yukonisen.potatocore.event.timer.SendQQDailyProgressReminderMessage;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.NoSuchElementException;

import static me.dreamvoid.miraimc.api.MiraiBot.getOnlineBots;

public class PotatoCore extends JavaPlugin {
    private static PotatoCore instance;

    public static MiraiGroup getGroup() {
        if (getOnlineBots().size() == 0) {
            return null;
        }
        try {
            if (MiraiBot.getBot(Config.INSTANCE.getQqbot()).getGroup(Config.INSTANCE.getQqgroup()) == null) {
                PotatoCore.getInstance().getLogger().warning("Group ID error");
                return null;
            }
        } catch (NoSuchElementException elementException) {
            PotatoCore.getInstance().getLogger().warning("Robot ID error");
            return null;
        }
        return MiraiBot.getBot(Config.INSTANCE.getQqbot()).getGroup(Config.INSTANCE.getQqgroup());
    }

    public static PotatoCore getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveResource("data/schedule.yml", false);
        saveResource("potatobotcfg.yml", false);
        this.getLogger().info("[PotatoCore] Loading");
    }

    @Override
    public void onEnable() {
        instance = this;

        System.out.println("[PotatoCore] Registering event -> CommandExecutor");
        Bukkit.getPluginCommand("ptb").setExecutor(new PTBCommand());

        System.out.println("[PotatoCore] Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new GameChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerSessionListener(), this);
        getServer().getPluginManager().registerEvents(new GroupCommandListener(), this);
        getServer().getPluginManager().registerEvents(new OnQQMaterialInquiry(), this);
        getServer().getPluginManager().registerEvents(new GroupMsgListener(), this);
        getServer().getPluginManager().registerEvents(new OnQQDailyProgressReminder(), this);

        System.out.println("[PotatoCore] Registering event -> Timer");
        new SendQQDailyProgressReminderMessage().start(0, 80L);

        this.getLogger().info("PotatoCore ready.");
        this.getLogger().info("Current qqbot: " + Config.INSTANCE.getQqbot() + ", qqgroup: " + Config.INSTANCE.getQqgroup());

    }

    @Override
    public void onDisable() {
        System.out.println("PotatoCore Disabled");
    }

}