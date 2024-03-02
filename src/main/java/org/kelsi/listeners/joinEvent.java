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
        String config_player = plugin.getConfig().getString("stats." + player);
        Double config_value = plugin.getConfig().getDouble("stats." + player + ".psycho");
        if (!player.hasPlayedBefore()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mi give DAGGER WOODEN_DAGGER " + player.getName() + " 1");
        }

        if (!player.hasPlayedBefore()) {
            psycho.put(player, 0.0);
            plugin.getConfig().createSection("stats").createSection(String.valueOf(player)).set("psycho", psycho.get(player));
        } else if (player.hasPlayedBefore()) {
            psycho.put(Bukkit.getPlayer(Objects.requireNonNull(config_player)), config_value);
        }

    }

}
