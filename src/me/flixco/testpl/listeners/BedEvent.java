package me.flixco.testpl.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class BedEvent implements Listener {
    @EventHandler
    public void onBed(PlayerBedEnterEvent event){
        Player player = event.getPlayer();
        Server server = Bukkit.getServer();

        server.broadcastMessage(ChatColor.GREEN + player.getName() + " schläft.");
        server.broadcastMessage(ChatColor.GREEN + "Nacht wird übersprungen.");

        Bukkit.getWorld("world").setTime(6000);
        
        event.setCancelled(true);
    }
}
