package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class moneytakeCommand implements CommandExecutor {

    JavaPlugin plugin;
    public moneytakeCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = Bukkit.getPlayer(args[0]);
        String name = player.getName();
        int amount = 0;
        if (player.hasPermission("fransetcore.sponsor")) {
            amount = (int) (Integer.parseInt(args[1]) * 0.25);
        } else if (!player.hasPermission("fransetcore.sponsor")) {
            amount = Integer.parseInt(args[1]);
        }
        if (args.length <= 0) {
            return false;
        } else {
            if (args[0] == null) {
                return false;
            } else {
                if (args[1] == null) {
                    return false;
                } else {
                    if (sender.hasPermission("fransetcore.admin")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "balance take " + name + " " + amount);
                        Bukkit.getLogger().info("Команда: " + "balance take " + name + " " + amount);
                        return true;
                    }
                }
                return true;
            }
        }
    }
}