package me.flixco.testpl.listeners;

import me.flixco.testpl.AlteronMC;
import me.flixco.testpl.DiscordWebhook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceListener implements Listener {
    private String webhookURL = "https://ptb.discord.com/api/webhooks/1114883840931012803/sO1kEC7WZQwqSdFlwGHPRXk9ijStblUCUWSUgONVN4JosYKQOn6N2E7d8Jptx6EnAhWx";
    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event){
        if (!event.getPlayer().hasPermission("flix.admin")){
            Player player = event.getPlayer();
            Block block = event.getBlock();

            if(
                    block.getType() == Material.FIRE ||
                    block.getType() == Material.LAVA ||
                    block.getType() == Material.LAVA_BUCKET ||
                            block.getType() == Material.STATIONARY_LAVA ||
                            block.getType() == Material.PORTAL

            ){
                player.sendMessage("§a[Info] §cDu hast griefing Blöcke platziert.");
                player.sendMessage("§a[Info] §cZur sicherheit wurde ein §4Admin §cinformiert!");

                DiscordWebhook webhook = new DiscordWebhook(webhookURL);
                webhook.addEmbed(new DiscordWebhook.EmbedObject()
                        .setDescription("Der Block " + event.getBlock().getType() + " Wurde gesetzt.")
                        .setTitle("Grief detector")
                        .setAuthor(player.getName(), "","")
                        .setFooter(event.getBlock().getLocation().toString(), "")
                );
                try{
                    webhook.execute();
                }
                catch(java.io.IOException e){
                    Bukkit.getLogger().severe(e.getStackTrace().toString());
                }
            }
        }
    }
}
