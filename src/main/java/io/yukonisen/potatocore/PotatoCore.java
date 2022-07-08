package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.command.PTBCommand;
import io.yukonisen.potatocore.event.listener.OnGameEvent.OnGameChat;
import io.yukonisen.potatocore.event.listener.OnPlayerJoinOrQuit;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQChatMessage;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQCommandMessage;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQMaterialInquiry;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.NoSuchElementException;

public class PotatoCore extends JavaPlugin {
    private static PotatoCore instance;

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveResource("potatobotcfg.yml", false);
        this.getLogger().info("[PotatoCore] Loading");
    }

    public static PotatoCore getInstance() {
        return instance;
    }

    public static MiraiGroup getGroup() {
        try {
            if (MiraiBot.getBot(Config.INSTANCE.getQqbot()).getGroup(Config.INSTANCE.getQqgroup()) == null) {
                System.out.println("[PotatoCore] Group ID error");
                return null;
            }
        } catch (NoSuchElementException elementException) {
            System.out.println("[PotatoCore] Robot ID error");
            return null;
        }
        return MiraiBot.getBot(Config.INSTANCE.getQqbot()).getGroup(Config.INSTANCE.getQqgroup());
    }


    @Override
    public void onEnable() {

        System.out.println("[PotatoCore] Registering event -> CommandExecutor");
        Bukkit.getPluginCommand("ptb").setExecutor(new PTBCommand());

        instance = this;
        System.out.println("[PotatoCore] Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new OnGameChat(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new OnQQChatMessage(), this);
        getServer().getPluginManager().registerEvents(new OnQQMaterialInquiry(), this);
        getServer().getPluginManager().registerEvents(new OnQQCommandMessage(), this);

        this.getLogger().info("[PotatoCore] PotatoCore ready.");
        this.getLogger().info("[PotatoCore] " + "Current qqbot: " + Config.INSTANCE.getQqbot() + ", qqgroup: " + Config.INSTANCE.getQqgroup());

    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

}