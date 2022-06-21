package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.listener.OnGameChatEvent;
import io.yukonisen.potatocore.event.listener.OnPlayerJoinOrQuit;
import io.yukonisen.potatocore.event.listener.OnQQMessageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PotatoCore extends JavaPlugin {

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveResource("potatobotcfg.yml", false);
        System.out.println("[PotatoCore] Loading");
    }

    @Override
    public void onEnable() {

        System.out.println("Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new OnGameChatEvent(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new OnQQMessageEvent(), this);

        System.out.println("PotatoCore ready.");
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

}