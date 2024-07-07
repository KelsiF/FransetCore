package org.kelsi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class deathEvents implements Listener {

    JavaPlugin plugin;
    public deathEvents(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent event) {
        //Потеря опыта
        event.getEntity();
        Player player = event.getEntity();


        float exp = player.getExp();
        int level = player.getLevel();
        float num = exp * 25 / 100;
        if (exp > 0.1) {
            exp = exp - num;
            player.setExp(exp);
            player.sendMessage(ChatColor.RED + " \nВы потеряли 25% от общего количества вашего опыта, а именно: " + String.format("%.1f", num) + "\nТеперь ваш опыт равен: " + String.format("%.1f", exp) + "\n ");
        }
        if (exp <= 0.1) {
            level = level - 1;
            player.setLevel(level);
            player.sendMessage(ChatColor.RED + "\nПоскольку ваш опыт меньше или равен 0.1, то вас уровень понижен на 1 единицу.\nТеперь ваш уровень равен: " + level + "\n");
        }

        player = event.getPlayer();
        Location loc = plugin.getConfig().getLocation("locations.spawn");
        plugin.getConfig().options().copyDefaults();

        player.teleport(loc);

    }


}
