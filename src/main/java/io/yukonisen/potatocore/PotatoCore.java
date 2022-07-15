package io.yukonisen.potatocore;

import io.yukonisen.potatocore.event.command.PTBCommand;
import io.yukonisen.potatocore.event.listener.game.GameChatListener;
import io.yukonisen.potatocore.event.listener.game.PlayerSessionListener;
import io.yukonisen.potatocore.event.listener.group.GroupCommandListener;
import io.yukonisen.potatocore.event.listener.group.GroupMsgListener;
import io.yukonisen.potatocore.event.timer.GroupTodoRemindTimer;
import io.yukonisen.potatocore.util.Config;
import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.api.bot.MiraiGroup;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static me.dreamvoid.miraimc.api.MiraiBot.getOnlineBots;

public class PotatoCore extends JavaPlugin {
    private static PotatoCore instance;

    public static MiraiGroup getGroup() {
        if (getOnlineBots().size() == 0) {
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
        instance = this;

        System.out.println("[PotatoCore] Registering event -> CommandExecutor");
        Bukkit.getPluginCommand("ptb").setExecutor(new PTBCommand());

        System.out.println("[PotatoCore] Registering event -> Listener");
        getServer().getPluginManager().registerEvents(new GameChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerSessionListener(), this);
        getServer().getPluginManager().registerEvents(new GroupCommandListener(), this);
      //getServer().getPluginManager().registerEvents(new OnQQMaterialInquiry(), this);
        getServer().getPluginManager().registerEvents(new GroupMsgListener(), this);

        System.out.println("[PotatoCore] Registering event -> Timer");
        new GroupTodoRemindTimer().start(0, 80L);

        this.getLogger().info("PotatoCore ready.");
        this.getLogger().info("Current qqbot: " + Config.INSTANCE.getQqbot() + ", qqgroup: " + Config.INSTANCE.getQqgroup());

    }

    @Override
    public void onDisable() {
        System.out.println("PotatoCore Disabled");
    }

}