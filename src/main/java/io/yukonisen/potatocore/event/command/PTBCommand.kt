package io.yukonisen.potatocore.event.command

import io.yukonisen.potatocore.util.Config
import io.yukonisen.potatocore.util.Config.plugin
import io.yukonisen.potatocore.util.Lang
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class PTBCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        //reload command
        if (args[0].equals("reload", ignoreCase = true)) {
            plugin.reloadConfig()
            sender.sendMessage(Config.mcPrefix + Lang.config_files_reloaded)
            return true
        }
        // invalid args
        sender.sendMessage(Config.qqPrefix + Lang.invalid_arguments)
        return false
    }
}