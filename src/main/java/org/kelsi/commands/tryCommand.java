package org.kelsi.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.utils.Utils;

import java.util.Random;

public class tryCommand implements CommandExecutor {

    private final String format = "&d* &7%s %s [%s]";

    private final String succes = "&aУдачно";

    private final String failed = "&cНеудачно";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("fransetcore.try")) {
            return true;
        }


        String message = String.join(" ", args);

        Random random = new Random();

        boolean result = random.nextBoolean();

        String finalMessage = "";

        if (result) {
            finalMessage = String.format(format, player.getName(), message, succes);
        } else {
            finalMessage = String.format(format, player.getName(), message, failed);
        }


        Utils.sendMessage(player, 25, finalMessage);

        return true;
    }

}
