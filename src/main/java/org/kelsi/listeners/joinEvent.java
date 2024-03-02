package org.kelsi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Objects;


public class joinEvent implements Listener {

    public static HashMap<Player, Double> psycho = new HashMap<>();

    JavaPlugin plugin;

    public joinEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mi give DAGGER WOODEN_DAGGER " + player.getName() + " 1");
        }

    }

}
