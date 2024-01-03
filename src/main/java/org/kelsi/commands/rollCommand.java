package org.kelsi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.utils.Utils;

import java.util.Random;

public class rollCommand implements CommandExecutor {

    private final String format = "&6* &7%s %s | &f%s";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("fransetcore.roll")) {
            return true;
        }


        String message = String.join(" ", args);

        Random random = new Random();

        int result = random.nextInt(100);

        String finalMessage = String.format(format, player.getName(), message, result);

        Utils.sendMessage(player, 25, finalMessage);

        return true;
    }

}
