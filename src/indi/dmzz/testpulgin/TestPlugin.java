package indi.dmzz.testpulgin;

import org.bukkit.plugin.java.JavaPlugin;

public class TestPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("[TestPlugin]插件已加载");
    }

    @Override
    public void onDisable() {

        System.out.println("[TestPlugin]插件已卸载");
    }

}
