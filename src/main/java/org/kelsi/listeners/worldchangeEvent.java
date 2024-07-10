package org.kelsi.listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.kelsi.fransetcore;

public class worldchangeEvent implements Listener {

    private final fransetcore plugin;

    public worldchangeEvent(fransetcore plugin) {
        this.plugin = plugin;
    }

    private ProtocolManager protocolManager;

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();

        double x = player.getLocation().getX();
        double y = player.getLocation().getY();

        protocolManager = ProtocolLibrary.getProtocolManager();
        PacketContainer packet = new PacketContainer(PacketType.Play.Server.SET_BORDER_CENTER);
        packet.getWorldBorderActions().writeSafely(0, EnumWrappers.WorldBorderAction.SET_CENTER);
        packet.getDoubles().write(0, x);
        packet.getDoubles().write(1, y);
        protocolManager.sendServerPacket(player, packet);

    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        World world = player.getWorld();

        if (world.getName().equals("play")) {
            protocolManager = ProtocolLibrary.getProtocolManager();
            PacketContainer packet = new PacketContainer(PacketType.Play.Server.SET_BORDER_CENTER);
            packet.getWorldBorderActions().writeSafely(0, EnumWrappers.WorldBorderAction.SET_CENTER);
            packet.getDoubles().write(0, x);
            packet.getDoubles().write(1, y);
            protocolManager.sendServerPacket(player, packet);
        }
    }

}
