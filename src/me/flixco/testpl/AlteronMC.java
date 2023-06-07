package me.flixco.testpl;

import me.flixco.testpl.commands.repair;
import me.flixco.testpl.commands.testcmd;
import me.flixco.testpl.listeners.BreakListener;
import me.flixco.testpl.listeners.JoinListener;
import me.flixco.testpl.listeners.PlaceListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class AlteronMC extends JavaPlugin {
    private String webhookURL = "https://ptb.discord.com/api/webhooks/1114883840931012803/sO1kEC7WZQwqSdFlwGHPRXk9ijStblUCUWSUgONVN4JosYKQOn6N2E7d8Jptx6EnAhWx";
    private static AlteronMC instance;
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        DiscordWebhook webhook = new DiscordWebhook(webhookURL);
        webhook.addEmbed(new DiscordWebhook.EmbedObject().setDescription("Beta System Plugin geladen!").setTitle("System Nachricht"));
        try{
            webhook.execute();
        }
        catch(java.io.IOException e){
            Bukkit.getLogger().severe(e.getStackTrace().toString());
        }

        Bukkit.getServer().getLogger().info("Plugin geladen lmao");

        this.getCommand("test").setExecutor(new testcmd());
        this.getCommand("repair").setExecutor(new repair());

    Bukkit.getServer().getPluginManager().registerEvents(new PlaceListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new BreakListener(), this);
    Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    public static AlteronMC getInstance() {
        return instance;
    }
}
