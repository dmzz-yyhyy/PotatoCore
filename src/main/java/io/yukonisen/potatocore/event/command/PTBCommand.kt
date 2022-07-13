package io.yukonisen.potatocore.event.command

import io.yukonisen.potatocore.util.Config.configFilesReloaded
import io.yukonisen.potatocore.util.Config.invalidArguments
import io.yukonisen.potatocore.util.Config.mcPrefix
import io.yukonisen.potatocore.util.Config.plugin
import io.yukonisen.potatocore.util.Config.qqPrefix
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class PTBCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        //reload command
        if (args[0].equals("reload", ignoreCase = true)) {
            plugin.reloadConfig()
            sender.sendMessage(mcPrefix + configFilesReloaded)
            return true
        }
        // invalid args
        sender.sendMessage(qqPrefix + invalidArguments)
        return false
    }
}