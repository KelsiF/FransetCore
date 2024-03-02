package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class givestatsCommand implements CommandExecutor {

    JavaPlugin plugin;
    public givestatsCommand(JavaPlugin plugin) {this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // /givestats KelsiDev[0] 7[1] 1[2] health[3] mmoitems_HEALTH[4]
        if (args.length <= 0) {
            return false;
        } else if (args.length >= 1) {
            if (args[0] != null) {
                if (args[1] != null) {
                    if (args[2] != null) {
                        if (args[3] != null) {
                            if (args[4] != null) {
                                if (sender.hasPermission("fransetcore.admin")) {
                                    Player player = Bukkit.getPlayer(args[0]);
                                    String stat = args[3];
                                    String name = args[4];
                                    int value = Integer.parseInt(args[1] + args[2]);
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sk modifier remove " + player.getName() + " " + name + " silent true");
                                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sk modifier add " + player.getName() + " " + stat + " " + name + " " + value);
                                }

                                return true;
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
