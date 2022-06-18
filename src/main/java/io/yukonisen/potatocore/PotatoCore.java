package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.listener.OnGameChatEvent;
import io.yukonisen.potatocore.event.listener.OnPlayerJoinOrQuit;
import io.yukonisen.potatocore.event.listener.OnQQMessageEvent;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import sun.jvm.hotspot.HelloWorld;

public class PotatoCore extends JavaPlugin {

    //FileConfiguration config = getConfig();

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
        SendHelloWorldMsg();
    }

    private void SendHelloWorldMsg() {
        MiraiBot.getBot(Config.bot).getGroup(Config.group).sendMessageMirai(
                "PotatoCore started.\nVersion: " + getDescription().getVersion() + "\nBy " + getDescription().getAuthors()
        );
    }

    @Override
    public void onDisable() {
        System.out.println("Disabling PotatoCore");
    }

}