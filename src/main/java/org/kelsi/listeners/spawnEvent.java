package org.kelsi.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;


public class spawnEvent implements Listener {

    JavaPlugin plugin;

    public spawnEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent event) {
        Player player = event.getPlayer();
        Location loc = plugin.getConfig().getLocation("spawn");

        if (loc != null) {
            event.setSpawnLocation(loc);
            if (player.getLocation() != loc) {
                player.teleport(loc);
            }
        }
    }

    @EventHandler
    public void onPlayerReSpawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Location loc = plugin.getConfig().getLocation("v");
        plugin.getConfig().options().copyDefaults();

        event.setRespawnLocation(loc);
        player.teleport(loc);
    }

}
