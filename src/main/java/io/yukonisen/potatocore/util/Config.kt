package io.yukonisen.potatocore.util

import io.yukonisen.potatocore.PotatoCore
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

object Config {
    private val plugin: Plugin = PotatoCore.getPlugin(PotatoCore::class.java)
    val PTBConfig: FileConfiguration = YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "potatobotcfg.yml"))

    const val group = 605822090
    const val bot = 1361161852
}