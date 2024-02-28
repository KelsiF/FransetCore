package org.kelsi.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.yic.xconomy.api.XConomyAPI;
import me.yic.xconomy.data.syncdata.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class loctpCommand implements CommandExecutor {

    JavaPlugin plugin;

    public loctpCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        // /loctp <игрок> <требуемый уровень> <xyz>
        // /loctp KelsiDev 5 0 0 0
        int amount = 100 + 10 * Integer.parseInt(args[1]);
        if (args.length <= 0) {
            return false;
        }
        if (sender.hasPermission("fransetcore.teleport")) {
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
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "balance take " + sender + " " + amount * 0.25);
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
            // если не спонсор
            Player target = Bukkit.getPlayer(args[0]);
            int x = Integer.parseInt(args[2]);
            int y = Integer.parseInt(args[3]);
            int z = Integer.parseInt(args[4]);
            if (target.getLevel() >= Integer.parseInt(args[1])) {
                target.teleport(new Location(Bukkit.getWorld("play"), x, y, z, 0, 0));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "balance take " + sender + " " + amount);
                return true;
            } else {
                target.sendMessage("У вас недостаточен уровень!");
                return true;
            }

        }
        return true;
    }
}
