package me.flixco.testpl.listeners;

import me.flixco.testpl.DiscordWebhook;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {
    private String webhookURL = "https://ptb.discord.com/api/webhooks/1114883840931012803/sO1kEC7WZQwqSdFlwGHPRXk9ijStblUCUWSUgONVN4JosYKQOn6N2E7d8Jptx6EnAhWx";
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (
                block.getType() == Material.DIAMOND_ORE ||
                    block.getType() == Material.IRON_ORE ||
                block.getType() == Material.GOLD_ORE
        ){
            DiscordWebhook webhook = new DiscordWebhook(webhookURL);
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setDescription("Das erz" + event.getBlock().getType() + " wurde gefarmt")
                    .setTitle("Xray schutz")
                    .setAuthor(player.getName(), "","")
                    .setFooter(block.getWorld().toString(), "")
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
