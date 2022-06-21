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
        this.getLogger().info("[PotatoCore] Loading");
    }

    @Override
    public void onEnable() {

        this.getLogger().info("Registering events -> Listener");
        getServer().getPluginManager().registerEvents(new OnGameChatEvent(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new OnQQMessageEvent(), this);

        this.getLogger().info("PotatoCore ready.");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Disabling PotatoCore");
    }

}