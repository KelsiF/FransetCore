package org.kelsi.commands;

import com.github.yannicklamprecht.worldborder.api.WorldBorderApi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;
import org.kelsi.fransetcore.*;

import static org.bukkit.Bukkit.getServer;

public class fborderCommand implements CommandExecutor {

    private final fransetcore plugin;

    public fborderCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("fransetcore.admin")) {
            RegisteredServiceProvider<WorldBorderApi> worldBorderApiRegisteredServiceProvider = getServer().getServicesManager().getRegistration(WorldBorderApi.class);

            if (worldBorderApiRegisteredServiceProvider == null) {
                plugin.getLogger().info("API not found");
                getServer().getPluginManager().disablePlugin(plugin);
            }
            assert worldBorderApiRegisteredServiceProvider != null;
            WorldBorderApi worldBorderApi = worldBorderApiRegisteredServiceProvider.getProvider();

            if (args.length >= 1) {
                Player target = Bukkit.getPlayer(args[0]);
                double size = Double.parseDouble(args[1]);
                worldBorderApi.setBorder(target, size);

                if (sender instanceof Player) {
                    assert target != null;
                    sender.sendMessage(ChatColor.GREEN + "Барьер для игрока " + target.getName() + " был установлен размером " + size);
                }
            }
        }

        return false;
    }
}
