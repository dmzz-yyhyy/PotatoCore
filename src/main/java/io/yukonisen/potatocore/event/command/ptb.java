package io.yukonisen.potatocore.event.command;

import io.yukonisen.potatocore.util.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.getVersion;

public class ptb implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // reload command
        if (args[0].equalsIgnoreCase("reload")) {
            Config.INSTANCE.getPlugin().reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.INSTANCE.getPrefix_MC() + "&aConfig files reloaded"));
            return true;
        }
        // invalid method
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.INSTANCE.getPrefix_MC() + "&cdon't know"));
        return false;
    }
}