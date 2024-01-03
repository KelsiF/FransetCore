package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;

public class eventCommand implements CommandExecutor {

    private final fransetcore plugin;

    public eventCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location coord = plugin.getConfig().getLocation("event");

            if (coord != null) {
                player.teleport(coord);

                player.sendMessage(ChatColor.GREEN + "Вы были телепортированы на точку проведения ивента");
            }else {
                player.sendMessage(ChatColor.RED + "Администрация не установила место проведения ивента.");
            }
        }

        return true;
    }
}
