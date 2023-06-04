package me.flixco.testpl.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class pl implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.isOp()){
            Bukkit.getServer().getPluginManager().getPlugins();
        }
    commandSender.sendMessage(ChatColor.RED + "Hierzu fehlen die die rechte");
        return false;
    }
}
