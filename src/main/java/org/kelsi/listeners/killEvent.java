package org.kelsi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.listeners.joinEvent.*;

public class killEvent implements Listener {

    JavaPlugin plugin;
    public killEvent(JavaPlugin plugin) {this.plugin = plugin;}

    @EventHandler
    public void onPlayerKilled(PlayerDeathEvent event) {
        Player killed = event.getEntity().getPlayer();
        Player killer = null;
        if (killed != null) {
            killer = killed.getKiller();
        }

        if (killer != null) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "svar add psycho 2.5 " + killer.getName());
            joinEvent.psycho.put(killer.getPlayer(), joinEvent.psycho.get(killer.getPlayer()) + 2.5);
            if (plugin.getConfig().getBoolean("settings.debug")) {
                Bukkit.getLogger().info("psycho added 2.5");
            }
        }
    }

    @EventHandler
    public void onEntityKilled(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();

        Player killer = entity.getKiller();
        if (killer != null) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "svar add psycho 0.5 " + killer.getName());
            joinEvent.psycho.put(killer.getPlayer(), joinEvent.psycho.get(killer.getPlayer()) + 0.5);
            if (plugin.getConfig().getBoolean("settings.debug")) {
                Bukkit.getLogger().info("psycho added 0.5");
            }
        }
    }



}
