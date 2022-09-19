package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.command.PTBCommand;
import io.yukonisen.potatocore.event.listener.PlayerJoinQuitEvent;
import io.yukonisen.potatocore.event.listener.game.GameChatListener;
import io.yukonisen.potatocore.event.listener.group.GroupCommandListener;
import io.yukonisen.potatocore.event.listener.group.GroupMesssageEvent;
import io.yukonisen.potatocore.event.timer.GroupTodoRemindTimer;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.NoSuchElementException;
import java.util.logging.Level;

import static me.dreamvoid.miraimc.api.MiraiBot.getOnlineBots;

public class PotatoCore extends JavaPlugin {
    private static PotatoCore instance;

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

    public static PotatoCore getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        this.getLogger().info("[PotatoCore] Loading");
        getConfig().options().copyDefaults();
        saveResource("data/todolist.yml", false);
        saveResource("potatobotcfg.yml", false);
    }

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "[PotatoCore] version " + getDescription().getVersion());
        Bukkit.getPluginCommand("ptb").setExecutor(new PTBCommand());

        instance = this;
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new GroupMesssageEvent(), this);
        pm.registerEvents(new GroupCommandListener(), this);
        pm.registerEvents(new PlayerJoinQuitEvent(), this);
        pm.registerEvents(new GameChatListener(), this);
        new GroupTodoRemindTimer().start(0, 80L);

        getLogger().log(Level.INFO,"PotatoCore ready.");
        getLogger().log(Level.INFO,"Current QQ bot: " + Config.INSTANCE.getQqbot() + ", group: " + Config.INSTANCE.getQqgroup());

    }

    @Override
    public void onDisable() {
        System.out.println("PotatoCore Disabled");
    }

}