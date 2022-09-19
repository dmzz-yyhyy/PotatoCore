package io.yukonisen.potatocore.util

import io.yukonisen.potatocore.PotatoCore
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

object Config {
    val plugin: Plugin = PotatoCore.getPlugin(PotatoCore::class.java)
    var PluginConfig: FileConfiguration = YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "config.yml"))
    var PTBConfig: FileConfiguration = YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "potatobotcfg.yml"))
    val playerJoinMsg: String = PTBConfig.getString("broadcast.messages.join")
    val playerQuitMsg: String = PTBConfig.getString("broadcast.messages.quit")
    val broadcastEnabled: Boolean = PTBConfig.getBoolean("broadcast.messages.enabled")
    val qqbot: Long = PTBConfig.getLong("qqnumber.bot")
    val qqgroup: Long = PTBConfig.getLong("qqnumber.group")
    val qqop: MutableList<String>? = PTBConfig.getStringList("qqnumber.op")
    val mcPrefix: String = plugin.config.getString("format.prefix.to-mc")
    val qqPrefix: String = plugin.config.getString("format.prefix.to-qq")
    val scheduleTimer: String = plugin.config.getString("schedule_timer")
}