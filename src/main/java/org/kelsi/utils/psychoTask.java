package org.kelsi.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.kelsi.listeners.joinEvent;

import java.util.Random;

public class psychoTask extends BukkitRunnable {

    JavaPlugin plugin;
    public psychoTask(JavaPlugin plugin) {this.plugin = plugin;}

    Player player;
    public psychoTask(Player player) {this.player = player;}

    @Override
    public void run() {
        if (joinEvent.psycho.get(player) >= 50) {
            if (new Random().nextInt(10 - 1) + 1 >= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1));
            } else {
                if (plugin.getConfig().getBoolean("settings.debug")) {
                    Bukkit.getLogger().info("random < 5");
                }
            }
        }
        if (joinEvent.psycho.get(player) >= 65) {
            if (new Random().nextInt(10 - 1) + 1 >= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5, 1));
            }
        }
        if (joinEvent.psycho.get(player) >= 70) {
            if (new Random().nextInt(10 - 1) + 1 >= 5) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, 7, 1));
            } else {
                if (plugin.getConfig().getBoolean("settings.debug")) {
                    Bukkit.getLogger().info("random < 5");
                }
            }
            if (joinEvent.psycho.get(player) >= 80) {
                if (new Random().nextInt(10 - 1) + 1 >= 5) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 5, 1));
                } else {
                    if (plugin.getConfig().getBoolean("settings.debug")) {
                        Bukkit.getLogger().info("random < 5");
                    }
                }
            }
        }
    }
}
