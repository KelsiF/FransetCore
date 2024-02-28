package org.kelsi.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Sound.*;

public class broadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {



        if(sender.hasPermission("fransetcore.broadcast")) {

            if (args.length >= 1) {
                String msg = "";
                for (int i = 0; i < args.length; i++) {
                    msg = msg + args[i] + " ";
                }

                Bukkit.broadcastMessage("");
                Bukkit.broadcastMessage(msg.replaceAll("&", "§"));
                Bukkit.broadcastMessage("");

                Bukkit.getOnlinePlayers().forEach(players -> players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2));

            }else {
                sender.sendMessage("Usage: /bc <text>");
            }

        } else {
            sender.sendMessage("Недостаточно прав!");
        }

        return false;
    }
}
