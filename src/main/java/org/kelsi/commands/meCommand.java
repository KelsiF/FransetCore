package org.kelsi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.utils.Utils;

public class meCommand implements CommandExecutor {

    private final String format = "&6* &7%s %s";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("fransetcore.me")) {
            return true;
        }


        String message = String.join(" ", args);

        String finalMessage = String.format(format, player.getName(), message);

        Utils.sendMessage(player, 25, finalMessage);

        return true;
    }
}
