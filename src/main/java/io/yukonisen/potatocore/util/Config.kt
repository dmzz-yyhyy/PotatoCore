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
    val qqbot: Long = PTBConfig.getLong("qqnumber.bot")
    val qqgroup: Long = PTBConfig.getLong("qqnumber.group")
    val qqop: MutableList<String>? = PTBConfig.getStringList("qqnumber.op")
    val mcPrefix: String = plugin.config.getString("format.prefix.to-mc")
    val qqPrefix: String = plugin.config.getString("format.prefix.to-qq")
    val scheduleTimer: String = plugin.config.getString("schedule_timer")

    //language
    val language: String = plugin.config.getString("language")
    val languageConfig: FileConfiguration =
        YamlConfiguration.loadConfiguration(File(plugin.dataFolder, "language/" + language + ".yml"))
    val configFilesReloaded: String = languageConfig.getString("config_files_reloaded")
    val invalidArguments: String = languageConfig.getString("invalid_arguments")
    val responsible: String = languageConfig.getString("responsible")
    val congratulations: String = languageConfig.getString("congratulations")
    val successfullyCompleteProgram: String = languageConfig.getString("successfully_complete_program")
    val completeScheduleError: String = languageConfig.getString("complete_schedule_error")
    val completeScheduleIncompleteParameters: String =
        languageConfig.getString("complete_schedule_incomplete_parameters")
    val successfullySettingSchedule: String = languageConfig.getString("successfully_setting_schedule")
    val settingScheduleError: String = languageConfig.getString("setting_schedule_error")
    val settingScheduleIncompleteParameters: String = languageConfig.getString("setting_schedule_incomplete_parameters")
    val scheduleAddedSuccessfully: String = languageConfig.getString("schedule_added_successfully")
    val scheduleAddedIncompleteParameters: String = languageConfig.getString("schedule_added_incomplete_parameters")
    val unfinishedSchedule: String = languageConfig.getString("unfinished_schedule")
    val sendScheduleTimer: String = languageConfig.getString("send_schedule_timer")
    val comeOntoday: String = languageConfig.getString("come_on_today")
}