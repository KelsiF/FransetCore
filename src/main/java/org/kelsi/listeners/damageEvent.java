package org.kelsi.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class damageEvent implements Listener {

    JavaPlugin plugin;
    public damageEvent(JavaPlugin plugin) {this.plugin = plugin;}


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();

        double damage = event.getDamage();
        double min = damage/1.5;
        double max = damage*1.5;
        double final_damage = damage/1.5 + (new Random().nextDouble() * (damage*1.5-damage/1.5));

        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntity();

            event.setCancelled(true);
            entity.damage(final_damage);
            entity.setVelocity(damager.getLocation().getDirection().multiply(1.5));
            if (!plugin.getConfig().getBoolean("settings.debug")) {
                plugin.getLogger().info("Базовый урон: " + damage + "\nмин./макс. урон " + min + "/" + max + "\n \nфинальный урон: " + final_damage);
            }
        }
    }

}
