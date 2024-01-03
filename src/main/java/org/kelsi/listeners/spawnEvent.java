package org.kelsi.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
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

        ItemStack slot = new ItemStack(Material.BARRIER);
        Inventory inv = player.getInventory();
        for (int x = 9; x <= 35; x++) {
            inv.setItem(x, slot);
        }
    }

}
