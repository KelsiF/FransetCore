package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;

public class spawnCommand implements CommandExecutor {

    private final fransetcore plugin;

    public spawnCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        if (args.length <= 0) {
            Location loc = plugin.getConfig().getLocation("locations.spawn");
            if (loc != null) {
                player.teleport(loc);
            } else {
                player.sendMessage(ChatColor.RED + "Администрация не установила точку спавна");
                plugin.getLogger().warning(ChatColor.RED + "Администрация, вы не установили точку спавна!");
            }
        }
        if (args.length > 0) {
            if (args[0].equals("set")) {
                if (sender.hasPermission("fransetcore.setspawn")) {
                    Location loc = player.getLocation();
                    plugin.getConfig().createSection("locations").set("spawn", loc);
                    plugin.saveConfig();

                    player.sendMessage(ChatColor.GREEN + "Точка спавна установлена!");

                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "У вас недостаточно прав!");

                    return true;
                }
            }
            if (args[0].equals("help")) {
                return false;
            }
        }

        return true;
    }
}
