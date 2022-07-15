package io.yukonisen.potatocore.util

import io.yukonisen.potatocore.PotatoCore
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

object TodoReminder {
    private val todoListFile: FileConfiguration =
        YamlConfiguration.loadConfiguration(File(PotatoCore.getInstance().dataFolder, "data/todolist.yml"))

    private fun getTodoData(todoName: String): Map<*, *>? {
        for (todo: Map<*, *> in todoListFile.getMapList("todo"))
            if (todo["item"].toString() == todoName) {
                return todo
            }
        return null
    }

    private fun getTodoLeader(todoName: String): String? {
        val todoData: Map<*, *>
        if (getTodoData(todoName) == null) {
            return null
        } else {
            todoData = getTodoData(todoName) as Map<*, *>
        }
        var leaders = ""
        for (leaderName in todoData["leaders"] as List<*>) {
            leaders += ", $leaderName"
        }
        leaders = leaders.replaceFirst(", ", "")
        return leaders
    }

    private fun getTodoItem(todoName: String): String? {
        val todoData: Map<*, *>
        if (getTodoData(todoName) == null) {
            return null
        } else {
            todoData = getTodoData(todoName) as Map<*, *>
        }
        var todo: String = todoData["item"].toString()
        val leaderName = getTodoLeader(todoName)
        todo += "\n      ${Config.responsible}:$leaderName"
        return todo
    }

    private fun getAllTodo(): String {
        var todoList = ""
        for (todo: Map<*, *> in todoListFile.getMapList("todo")) {
            todoList += "\n" + getTodoItem(todo["item"].toString())
        }
        todoList = todoList.replaceFirst("\n", "")
        return todoList
    }

    private fun setTodoData(
        oldTodoName: String,
        newTodoName: String,
        leadersList: List<String>,
        storage: String
    ) {
        val todoDataList: MutableList<MutableMap<*, *>>? = todoListFile.getMapList("todo")
        val todoMap: MutableMap<String, Any> = HashMap()
        todoMap["item"] = newTodoName
        todoMap["leaders"] = leadersList
        todoMap["storage"] = storage
        var index = 0
        if (todoDataList != null) {
            while (index < todoDataList.size) {
                if (todoDataList[index]["item"] == oldTodoName) {
                    todoDataList.removeAt(index)
                }
                index++
            }
            todoDataList.add(todoMap)
        }
        todoListFile.set("data", todoDataList)
        try {
            todoListFile.save(File(PotatoCore.getInstance().dataFolder, "data/todolist.yml"))
        } catch (ignored: IOException) {
        }
    }

    private fun removeTodoData(todo: String) {
        val todoDataList: MutableList<MutableMap<*, *>>? = todoListFile.getMapList("todo")
        var index = 0
        if (todoDataList != null) {
            while (index < todoDataList.size) {
                if (todoDataList[index]["item"] == todo) {
                    todoDataList.removeAt(index)
                }
                index++
            }
        }
        todoListFile.set("data", todoDataList)
        try {
            todoListFile.save(File(PotatoCore.getInstance().dataFolder, "data/todolist.yml"))
        } catch (ignored: IOException) {
        }
    }

    fun checkTodo(): String {
        var message: String = Config.unfinishedSchedule
        message += "\n" + getAllTodo()
        return message
    }

    fun addTodo(args: List<String>): String {
        var message: String
        if (!((args.size == 3) or (args.size == 4))) {
            message = Config.scheduleAddedIncompleteParameters
            return message
        }
        val leadersList: List<String> = args[2].split("|")
        if (args.size == 3) {
            setTodoData("", args[1], leadersList, "null")
        }
        if (args.size == 4) {
            setTodoData("", args[1], leadersList, args[3])
        }
        message = Config.scheduleAddedSuccessfully
        message = message + "\n" + getTodoItem(args[1])
        return message
    }

    fun modifyTodo(args: List<String>): String {
        var message: String
        if (!((args.size == 4) or (args.size == 5))) {
            message = Config.settingScheduleIncompleteParameters
            return message
        }
        if (getTodoData(args[1]) == null) {
            message = Config.settingScheduleError
            return message
        }
        message = Config.successfullySettingSchedule
        val leadersList: List<String> = args[3].split("|")
        if (args.size == 4) {
            setTodoData(args[1], args[2], leadersList, "null")
        }
        if (args.size == 5) {
            setTodoData(args[1], args[2], leadersList, args[4])
        }
        message = message + "\n" + getTodoItem(args[2])
        return message
    }

    fun completeTodo(args: List<String>): String {
        var message: String
        if (args.size != 2) {
            message = Config.completeScheduleIncompleteParameters
            return message
        }
        if (getTodoData(args[1]) == null) {
            message = Config.completeScheduleError
            return message
        }
        message = Config.successfullyCompleteProgram
        message = "$message\n" + getTodoItem(args[1]) + "${Config.congratulations}\n"
        removeTodoData(args[1])
        return message
    }
}
