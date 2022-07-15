package io.yukonisen.potatocore.util

import io.yukonisen.potatocore.PotatoCore
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

object Lang {

    private val plugin: Plugin = PotatoCore.getPlugin(PotatoCore::class.java)

    private val language: String = plugin.config.getString("language")
    private val languageConfig: FileConfiguration =
        YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "language/$language.yml"))
    val config_files_reloaded: String = languageConfig.getString("config_files_reloaded")
    val invalid_arguments: String = languageConfig.getString("invalid_arguments")
    val leaders: String = languageConfig.getString("leaders")
    val congratulations: String = languageConfig.getString("congratulations")
    val todo_completed: String = languageConfig.getString("todo_completed")
    val error_completing_todo: String = languageConfig.getString("error_completing_todo")
    val error_completing_todo_invalid_args: String =
        languageConfig.getString("error_completing_todo_invalid_args")
    val todo_modified: String = languageConfig.getString("todo_modified")
    val error_modifying_todo: String = languageConfig.getString("error_modifying_todo")
    val error_modifying_todo_invalid_args: String = languageConfig.getString("error_modifying_todo_invalid_args")
    val todo_added: String = languageConfig.getString("todo_added")
    val error_adding_todo_invalid_args: String = languageConfig.getString("error_adding_todo_invalid_args")
    val uncompleted_todo: String = languageConfig.getString("uncompleted_todo")
}