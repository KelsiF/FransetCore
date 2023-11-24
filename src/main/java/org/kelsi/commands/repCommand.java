package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;

import static org.kelsi.fransetcore.rep;


public class repCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Integer value = rep.get(player.getUniqueId());
            if (args.length < 1) {
                player.sendMessage("Ваша порядочность: " + value);
            }
            if(args.length >= 1) {
                if (args[0].equalsIgnoreCase("minus")) {
                    if (rep.containsKey(player.getUniqueId())) {
                        if (sender.hasPermission("fransetcore.minusrep")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (args[1] != null) {
                                int amount = Integer.parseInt(args[2]);
                                int result = value - amount;
                                rep.put(target.getUniqueId(), result);
                                target.sendMessage("Ваша порядочность изменилась");
                            }else{
                                player.sendMessage(ChatColor.RED + "Укажите ник игрока");
                            }
                        }
                    }else {
                        player.sendMessage(ChatColor.RED + "Такого игрока не существует!");
                    }
                }
                if (args[0].equalsIgnoreCase("plus")) {
                    if (rep.containsKey(player.getUniqueId())) {
                        if (sender.hasPermission("fransetcore.plusrep")) {
                            Player target = Bukkit.getPlayer(args[1]);
                            if (args[1] != null) {
                                int amount = Integer.parseInt(args[2]);
                                int result = value + amount;
                                rep.put(target.getUniqueId(), result);
                                target.sendMessage("Ваша порядочность изменилась");
                            }else{
                                player.sendMessage(ChatColor.RED + "Укажите ник игрока");
                            }
                        }
                    }else {
                        player.sendMessage(ChatColor.RED + "Такого игрока не существует!");
                    }
                }
            }
        }

            return true;
        }
    }
