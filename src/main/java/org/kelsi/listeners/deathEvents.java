package org.kelsi.listeners;

import org.bukkit.ChatColor;
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
        event.getEntity();
        Player player = event.getEntity();

        float exp = player.getExp();
        float num = exp * 25 / 100;
        exp = exp - num;
        player.setExp(exp);
        player.sendMessage(ChatColor.RED + " \nВы потеряли 25% от общего количества вашего опыта, а именно: " + String.format("%.1f", num) + "\nТеперь ваш опыт равен: " + String.format("%.1f", exp) + "\n ");
    }

}
