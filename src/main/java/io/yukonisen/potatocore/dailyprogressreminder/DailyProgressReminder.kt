package io.yukonisen.potatocore.dailyprogressreminder

import io.yukonisen.potatocore.PotatoCore
import io.yukonisen.potatocore.util.Config
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

object DailyProgressReminder {
    private val scheduleConfig: FileConfiguration =
        YamlConfiguration.loadConfiguration(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))

    private fun getScheduleData(scheduleName: String): Map<*, *>? {
        for (schedule: Map<*, *> in scheduleConfig.getMapList("data"))
            if (schedule["schedule"].toString() == scheduleName) {
                return schedule
            }
        return null
    }

    private fun getSchedulerResponsible(scheduleName: String): String? {
        val scheduleData: Map<*, *>
        if (getScheduleData(scheduleName) == null) {
            return null
        } else {
            scheduleData = getScheduleData(scheduleName) as Map<*, *>
        }
        var responsibleNames = ""
        for (responsibleName in scheduleData["responsible"] as List<*>) {
            responsibleNames += ", $responsibleName"
        }
        responsibleNames = responsibleNames.replaceFirst(", ", "")
        return responsibleNames
    }

    private fun getSchedule(scheduleName: String): String? {
        val scheduleData: Map<*, *>
        if (getScheduleData(scheduleName) == null) {
            return null
        } else {
            scheduleData = getScheduleData(scheduleName) as Map<*, *>
        }
        var schedule: String = scheduleData["schedule"].toString()
        val responsibleName = getSchedulerResponsible(scheduleName)
        schedule += "\n      ${Config.responsible}:$responsibleName"
        return schedule
    }

    private fun getAllSchedule(): String {
        var allSchedule = ""
        for (schedule: Map<*, *> in scheduleConfig.getMapList("data")) {
            allSchedule += "\n" + getSchedule(schedule["schedule"].toString())
        }
        allSchedule = allSchedule.replaceFirst("\n", "")
        return allSchedule
    }

    private fun setScheduleData(
        oldScheduleName: String,
        newScheduleName: String,
        scheduleResponsibleList: List<String>,
        warehouse: String
    ) {
        val scheduleDataList: MutableList<MutableMap<*, *>>? = scheduleConfig.getMapList("data")
        val scheduleMap: MutableMap<String, Any> = HashMap()
        scheduleMap["schedule"] = newScheduleName
        scheduleMap["responsible"] = scheduleResponsibleList
        scheduleMap["warehouse"] = warehouse
        var index = 0
        if (scheduleDataList != null) {
            while (index < scheduleDataList.size) {
                if (scheduleDataList[index]["schedule"] == oldScheduleName) {
                    scheduleDataList.removeAt(index)
                }
                index++
            }
            scheduleDataList.add(scheduleMap)
        }
        scheduleConfig.set("data", scheduleDataList)
        try {
            scheduleConfig.save(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
        } catch (ignored: IOException) {
        }
    }

    private fun removeScheduleData(schedule: String) {
        val scheduleDataList: MutableList<MutableMap<*, *>>? = scheduleConfig.getMapList("data")
        var index = 0
        if (scheduleDataList != null) {
            while (index < scheduleDataList.size) {
                if (scheduleDataList[index]["schedule"] == schedule) {
                    scheduleDataList.removeAt(index)
                }
                index++
            }
        }
        scheduleConfig.set("data", scheduleDataList)
        try {
            scheduleConfig.save(File(PotatoCore.getInstance().dataFolder, "data/schedule.yml"))
        } catch (ignored: IOException) {
        }
    }

    fun checkSchedule(): String {
        var message: String = Config.unfinishedSchedule
        message += "\n" + getAllSchedule()
        return message
    }

    fun addSchedule(args: List<String>): String {
        var message: String
        if (!((args.size == 3) or (args.size == 4))) {
            message = Config.scheduleAddedIncompleteParameters
            return message
        }
        val scheduleResponsibleList: List<String> = args[2].split("|")
        if (args.size == 3) {
            setScheduleData("", args[1], scheduleResponsibleList, "null")
        }
        if (args.size == 4) {
            setScheduleData("", args[1], scheduleResponsibleList, args[3])
        }
        message = Config.scheduleAddedSuccessfully
        message = message + "\n" + getSchedule(args[1])
        return message
    }

    fun setSchedule(args: List<String>): String {
        var message: String
        if (!((args.size == 4) or (args.size == 5))) {
            message = Config.settingScheduleIncompleteParameters
            return message
        }
        if (getScheduleData(args[1]) == null) {
            message = Config.settingScheduleError
            return message
        }
        message = Config.successfullySettingSchedule
        val scheduleResponsibleList: List<String> = args[3].split("|")
        if (args.size == 4) {
            setScheduleData(args[1], args[2], scheduleResponsibleList, "null")
        }
        if (args.size == 5) {
            setScheduleData(args[1], args[2], scheduleResponsibleList, args[4])
        }
        message = message + "\n" + getSchedule(args[2])
        return message
    }

    fun completeSchedule(args: List<String>): String {
        var message: String
        if (args.size != 2) {
            message = Config.completeScheduleIncompleteParameters
            return message
        }
        if (getScheduleData(args[1]) == null) {
            message = Config.completeScheduleError
            return message
        }
        message = Config.successfullyCompleteProgram
        message = "$message\n" + getSchedule(args[1]) + "${Config.congratulations}\n"
        removeScheduleData(args[1])
        return message
    }
}
