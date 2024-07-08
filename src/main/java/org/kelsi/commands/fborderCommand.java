package org.kelsi.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.kelsi.fransetcore;
import org.kelsi.fransetcore.*;


public class fborderCommand implements CommandExecutor {

    private final fransetcore plugin;

    public fborderCommand(fransetcore plugin) {
        this.plugin = plugin;
    }

    private ProtocolManager protocolManager;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission("fransetcore.admin")) {


            if (args.length >= 1) {
                Player target = Bukkit.getPlayer(args[0]);
                double size = Double.parseDouble(args[1]);

                assert target != null;
                protocolManager = ProtocolLibrary.getProtocolManager();
                PacketContainer packet = new PacketContainer(PacketType.Play.Server.SET_BORDER_SIZE);
                packet.getWorldBorderActions().writeSafely(0, EnumWrappers.WorldBorderAction.SET_SIZE);
                packet.getDoubles().write(0, size);
                protocolManager.sendServerPacket(target, packet);

                if (sender instanceof Player) {
                    sender.sendMessage(ChatColor.GREEN + "Барьер для игрока " + target.getName() + " был установлен размером " + size);
                } else {
                    plugin.getLogger().info(ChatColor.GREEN + "Барьер для игрока " + target.getName() + " был установлен размером " + size);
                }
                return true;
            } else {
                return false;
            }
        }

        return true;
    }
}
