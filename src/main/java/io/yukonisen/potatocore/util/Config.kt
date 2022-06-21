package io.yukonisen.potatocore.util

import io.yukonisen.potatocore.PotatoCore
import me.dreamvoid.miraimc.api.MiraiBot
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import org.yaml.snakeyaml.Yaml
import java.io.File

object Config {

    private val plugin: Plugin = PotatoCore.getPlugin(PotatoCore::class.java)
    var PluginConfig: FileConfiguration = plugin.config
    var PTBConfig: FileConfiguration = YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "potatobotcfg.yml"))

    // val consolePrefix: String = PluginConfig.getString("format.prefix.console")
    val qqbot: Long = PTBConfig.getLong("qqnumber.bot")
    val qqgroup: Long = PTBConfig.getLong("qqnumber.group")
    // val qqop: Long = PTBConfig.getLong("qqnumber.op")

}