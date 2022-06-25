package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.listener.OnGameEvent.OnGameChat;
import io.yukonisen.potatocore.event.listener.OnPlayerJoinOrQuit;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQCommandMessage;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQMaterialInquiry;
import io.yukonisen.potatocore.event.listener.OnQQGroupMessageEvent.OnQQSynchronizeMessage;
import io.yukonisen.potatocore.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

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


    @Override
    public void onEnable() {

        instance = this;
        System.out.println("Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new OnGameChat(), this);
        getServer().getPluginManager().registerEvents(new OnPlayerJoinOrQuit(), this);
        getServer().getPluginManager().registerEvents(new OnQQSynchronizeMessage(), this);
        getServer().getPluginManager().registerEvents(new OnQQMaterialInquiry(), this);
        getServer().getPluginManager().registerEvents(new OnQQCommandMessage(), this);

        this.getLogger().info("PotatoCore ready.");
        this.getLogger().info("" +
                "Current qqbot: "+ Config.INSTANCE.getQqbot()+", qqgroup: "
                + Config.INSTANCE.getQqgroup());
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

}