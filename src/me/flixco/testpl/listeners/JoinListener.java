package me.flixco.testpl.listeners;

import me.flixco.testpl.DiscordWebhook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener  implements Listener {
    private String webhookURL = "https://ptb.discord.com/api/webhooks/1114883840931012803/sO1kEC7WZQwqSdFlwGHPRXk9ijStblUCUWSUgONVN4JosYKQOn6N2E7d8Jptx6EnAhWx";

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setDescription("Spieler" + player.getDisplayName() + "ist beigetreten")
                .setTitle("Join")
        );
        try {
            webhook.execute();
        } catch (java.io.IOException e) {
            Bukkit.getLogger().severe(e.getStackTrace().toString());
        }
    }
}
