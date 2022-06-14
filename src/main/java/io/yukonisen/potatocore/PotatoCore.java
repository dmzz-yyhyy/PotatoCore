package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.command.ptb;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class PotatoCore extends JavaPlugin {

    FileConfiguration config = getConfig();

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveResource("potatobotcfg.yml", false);
        System.out.println("[PotatoCore] Loading");
    }

    @Override
    public void onEnable() {

        System.out.println("Registering event -> CommandExecutor");
        Bukkit.getPluginCommand("ptb").setExecutor(new ptb());

        System.out.println("Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new io.yukonisen.potatocore.event.listener.OnNewChatEvent(), this);
        getServer().getPluginManager().registerEvents(new io.yukonisen.potatocore.event.listener.OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new io.yukonisen.potatocore.event.listener.QQMessageEvent(), this);

        System.out.println("PotatoCore ready.");
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

}