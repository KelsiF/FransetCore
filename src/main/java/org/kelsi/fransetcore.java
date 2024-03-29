package org.kelsi;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.*;
import org.kelsi.listeners.*;

import java.util.*;


public final class fransetcore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new spawnEvent(this), this);
        //getServer().getPluginManager().registerEvents(new inventorylimitEvents(this), this);
        getServer().getPluginManager().registerEvents(new deathEvents(this), this);
        getServer().getPluginManager().registerEvents(new joinEvent(this), this);
        getServer().getPluginManager().registerEvents(new levelupEvent(this), this);
        getServer().getPluginManager().registerEvents(new damageEvent(this), this);
        getServer().getPluginManager().registerEvents(new killEvent(this), this);
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new broadcastCommand());
        Objects.requireNonNull(getCommand("me")).setExecutor(new meCommand());
        Objects.requireNonNull(getCommand("do")).setExecutor(new doCommand());
        Objects.requireNonNull(getCommand("try")).setExecutor(new tryCommand());
        Objects.requireNonNull(getCommand("roll")).setExecutor(new rollCommand());
        Objects.requireNonNull(getCommand("removeevent")).setExecutor(new removeeventCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new spawnCommand(this));
        Objects.requireNonNull(getCommand("loc")).setExecutor(new locCommand(this));
        Objects.requireNonNull(getCommand("reset")).setExecutor(new resetCommand(this));
        getCommand("take").setExecutor(new moneytakeCommand(this));
        getCommand("givestats").setExecutor(new givestatsCommand(this));
        getCommand("psychopotion").setExecutor(new psychopotionCommand(this));
        YamlConfiguration conf = (YamlConfiguration) getConfig();
        if (!getConfig().contains("stats")) {
            getConfig().createSection("stats");
        }
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            /*
             * We register the EventListener here, when PlaceholderAPI is installed.
             * Since all events are in the main class (this class), we simply use "this"
             */
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    /*@Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new customGenerator();
    }*/
}

