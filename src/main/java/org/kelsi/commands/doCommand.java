package org.kelsi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.utils.Utils;

public class doCommand implements CommandExecutor {

    private final String format = "&e* &7%s &8(%s)";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("fransetcore.do")) {
            return true;
        }


        String message = String.join(" ", args);

        String finalMessage = String.format(format, message, player.getName());

        Utils.sendMessage(player, 25, finalMessage);

        return true;
    }

}
