package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class locCommand implements CommandExecutor {

    JavaPlugin plugin;

    public locCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // /loc <игрок> <требуемый уровень> <xyz>
        // /loc KelsiDev 5 0 0 0
        if (args.length <= 0) {
            return false;
        }
        if (sender.hasPermission("fransetcore.loc")) {
            if (args.length >= 1) {
                if (args[0] != null) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (args[1] != null) {
                        if (args[2] != null) {
                            int x = Integer.parseInt(args[2]);
                            if (args[3] != null) {
                                int y = Integer.parseInt(args[3]);
                                if (args[4] != null) {
                                    int z = Integer.parseInt(args[4]);
                                    if (target.getLevel() >= Integer.parseInt(args[1])) {
                                        target.teleport(new Location(Bukkit.getWorld("play"), x, y, z, 0, 0));
                                        return true;
                                    } else {
                                        target.sendMessage("У вас недостаточен уровень!");
                                        return true;
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
                } else {
                    Player player = (Player) sender;
                    if (args[1] != null) {
                        if (args[2] != null) {
                            int x = Integer.parseInt(args[2]);
                            if (args[3] != null) {
                                int y = Integer.parseInt(args[3]);
                                if (args[4] != null) {
                                    int z = Integer.parseInt(args[4]);
                                    if (player.getLevel() >= Integer.parseInt(args[1])) {
                                        player.teleport(new Location(Bukkit.getWorld("play"), x, y, z, 0, 0));
                                        return true;
                                    } else {
                                        player.sendMessage("У вас недостаточен уровень!");
                                        return true;
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
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "У вас нет прав!");
        }
        return true;
    }
}
