package io.yukonisen.potatocore.event.command;

import io.yukonisen.potatocore.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class PTBCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //reload command
        if (args[0].equalsIgnoreCase("reload")) {
            Config.INSTANCE.getPlugin().reloadConfig();
            sender.sendMessage(Config.INSTANCE.getMcPrefix() + Config.INSTANCE.getConfigFilesReloaded());
            return true;
        }
        // invalid args
        sender.sendMessage(Config.INSTANCE.getQqPrefix() + Config.INSTANCE.getInvalidArguments());
        return false;
    }
}