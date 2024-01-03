package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;

public class removeeventCommand implements CommandExecutor {

    public final fransetcore plugin;

    public removeeventCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (sender instanceof Player) {
            if (sender.hasPermission("fransetcore.removeevent")) {
                plugin.getConfig().set("event", null);
            }

        }
        if (!sender.hasPermission("fransetcore.removeevent")){
            player.sendMessage(ChatColor.RED + "У вас нет прав для окончания ивентВа!");
        }
        return true;
    }
}
