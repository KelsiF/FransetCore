package org.kelsi;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.*;
import org.kelsi.listeners.spawnEvent;

import java.util.Objects;


public final class fransetcore extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new spawnEvent(this), this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new broadcastCommand());
        Objects.requireNonNull(getCommand("me")).setExecutor(new meCommand());
        Objects.requireNonNull(getCommand("do")).setExecutor(new doCommand());
        Objects.requireNonNull(getCommand("try")).setExecutor(new tryCommand());
        Objects.requireNonNull(getCommand("roll")).setExecutor(new rollCommand());
        Objects.requireNonNull(getCommand("setevent")).setExecutor(new seteventCommand(this));
        Objects.requireNonNull(getCommand("removeevent")).setExecutor(new removeeventCommand(this));
        Objects.requireNonNull(getCommand("event")).setExecutor(new eventCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new spawnCommand(this));

       // }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }



}
