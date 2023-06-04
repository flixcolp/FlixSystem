package me.flixco.testpl.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class repair implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (commandSender.hasPermission("flix.repair")){
            player.getItemInHand().setDurability((short) 0);
            player.sendMessage("§a[Info] §2Item repariert.");
        } else{
            player.sendMessage("§a[Info] §cHierzu fehlen dir die Rechte");
        }

        return false;
    }
}
