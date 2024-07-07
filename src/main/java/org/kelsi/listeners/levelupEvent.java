package org.kelsi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class levelupEvent implements Listener {


    JavaPlugin plugin;

    public levelupEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeveupEvent(PlayerLevelChangeEvent event) {
        Player player = event.getPlayer();
        int level = event.getNewLevel();

        int modifier = level * 10;
        if (level > event.getOldLevel()) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skill xp add " + player.getName() + " agility " + modifier);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skill xp add " + player.getName() + " defense " + modifier);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skill xp add " + player.getName() + " endurance " + modifier);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skill xp add " + player.getName() + " fighting " + modifier);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "skill xp add " + player.getName() + " sorcery " + modifier);
            player.sendMessage(ChatColor.GREEN + "\nИз-за повышения уровня вы получили опыт к характеристикам" + ChatColor.GRAY + "(/skills)" + "\n");
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "svar add level_points 1 " + player.getName());
    }
}
