package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;

public class seteventCommand implements CommandExecutor {

    private final fransetcore plugin;

    public seteventCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (sender instanceof Player) {
            if (sender.hasPermission("fransetcore.setevent")) {
                Location coord = player.getLocation();

                plugin.getConfig().set("event", coord);
                plugin.saveConfig();

                player.sendMessage(ChatColor.GREEN + "Место проведения ивента создано!");
            }
            if (!sender.hasPermission("fransetcore.setevent")){
                player.sendMessage(ChatColor.RED + "У вас нет прав для проведения ивентов!");
            }
        }

        return true;
    }
}
