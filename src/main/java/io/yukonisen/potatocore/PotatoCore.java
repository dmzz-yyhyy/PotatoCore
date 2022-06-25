package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.listener.OnGameEvent.OnGameChat;
import io.yukonisen.potatocore.event.listener.OnGameEvent.OnPlayerJoinOrQuit;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQCommandMessage;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQMaterialInquiry;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQSynchronizeMessage;
import org.bukkit.plugin.java.JavaPlugin;

public class PotatoCore extends JavaPlugin {
    private static PotatoCore instance;

    @Override
    public void onLoad() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        saveResource("potatobotcfg.yml", false);
        System.out.println("[PotatoCore] Loading");
    }

    public static PotatoCore getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new OnGameChat(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new OnQQSynchronizeMessage(), this);
        getServer().getPluginManager().registerEvents(new OnQQMaterialInquiry(), this);
        getServer().getPluginManager().registerEvents(new OnQQCommandMessage(), this);

        System.out.println("PotatoCore ready.");
    }
}