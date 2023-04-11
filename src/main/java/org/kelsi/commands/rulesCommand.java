package org.kelsi.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class rulesCommand implements CommandExecutor{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;
        if (args.length == 0) {

            player.sendMessage(ChatColor.BOLD + "Общие правила сервера");
            player.sendMessage("1. Запрещено оскорблять игроков/персонал сервера. \n 2. Запрещено использование стороннего ПО/ресурс паков, дающий преимущество. \n 3. Запрещены любые действия, мешающие работе сервера.\n 4. Запрещено заниматься саморекламой.\n 5. Запрещён обход наказания через создание твинка.");
            player.sendMessage(ChatColor.BOLD + "Правила режима 'Vanila+'");
            player.sendMessage("1. Прежде всего, придерживайтесь моральных норм.\n 2. Запрещено гриферство в любых его проявлениях в радиусе 1000 блоков от спавна.");

        }

        /*if (args[0].equalsIgnoreCase("off")) {

            player.sendMessage("Вы отключили уведомления о правилах.");
            enabled_users.remove(player.getName());
            System.out.println(enabled_users.get(0));

        }*/

        return false;
    }
}
