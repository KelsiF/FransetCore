package org.kelsi.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.utils.psychoTask;


public class moveEvent implements Listener {
    JavaPlugin plugin;
    public moveEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        new psychoTask(player).runTaskTimer(this.plugin, 100, 20);
    }
}
