package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class psychopotionCommand implements CommandExecutor {

    JavaPlugin plugin;
    public psychopotionCommand(JavaPlugin plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (args.length <= 0) {
            return false;
        } else {
            if (args[1] != null) {
                if (sender.hasPermission("fransetcore.admin")) {
                    Player player = Bukkit.getPlayer(args[0]);
                    int value = Integer.parseInt(args[1]);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "svar reduce psycho " + value + " " + player.getName());
                }
                return true;
            } else {
                return false;
            }
        }
    }
}
