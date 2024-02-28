package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class resetCommand implements CommandExecutor {

    JavaPlugin plugin;

    public resetCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player senderr = (Player) sender;

        if (args.length <= 0) {

            for (Statistic statistic : Statistic.values()) {
                for (Material material : Material.values()) {
                    try {
                        senderr.setStatistic(statistic, material, 0);
                        senderr.sendMessage(ChatColor.GREEN + "Ваша статистика успешно сброшена!");
                        return true;
                    }
                    catch (IllegalArgumentException e) {
                        break;
                    }
                }
                try {
                    senderr.setStatistic(statistic, 0);
                } catch (IllegalArgumentException ignored) {}
            }
        } else {
            if (args[0].equals("all")) {
                if (senderr.hasPermission("fransetcore.resetall")) {
                    for (Statistic statistic : Statistic.values()) {
                        for (Material material : Material.values()) {
                            try {
                                for (OfflinePlayer offplayer : plugin.getServer().getOfflinePlayers()) {
                                    offplayer.setStatistic(statistic, material, 0);
                                    senderr.sendMessage(ChatColor.GREEN + "!");
                                    return true;
                                }
                                for (Player player : plugin.getServer().getOnlinePlayers()) {
                                    player.setStatistic(statistic, material, 0);
                                    return true;
                                }
                                try {
                                    senderr.setStatistic(statistic, 0);
                                } catch (IllegalArgumentException ignored) {}
                            }
                            catch (IllegalArgumentException e) {
                                break;
                            }
                        }
                    }
                } else {
                    senderr.sendMessage(ChatColor.RED + "У вас недостаточно прав!");
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
