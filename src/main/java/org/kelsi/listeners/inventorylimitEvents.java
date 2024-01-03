package org.kelsi.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import java.util.Arrays;

public class inventorylimitEvents implements Listener {

    JavaPlugin plugin;
    public inventorylimitEvents(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    int slots = 0;

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();
        if (inv.contains(Material.SHULKER_BOX)) {
            slots = 5;
        }
        if (inv.contains(Material.RED_SHULKER_BOX)) {
            slots = 10;
        }
        if (inv.contains(Material.PURPLE_SHULKER_BOX)) {
            slots = 20;
        }

        ItemStack slot = new ItemStack(Material.BARRIER);
        slot.setAmount(1);
        ItemMeta slotMeta = slot.getItemMeta();
        slotMeta.setDisplayName(ChatColor.RED + "Слот заблокирован");
        slotMeta.setCustomModelData(10000);
        for (int x = 9; x <= 35 - slots; x++) {
            slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
            slot.setItemMeta(slotMeta);
            inv.setItem(x, slot);
        }
    }

    @EventHandler
    public void onItemInteract(InventoryMoveItemEvent event) {
        Material item = event.getItem().getType();
        if (item.equals(Material.BARRIER)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryEvent(InventoryOpenEvent event) {
        Inventory inv = event.getInventory();
        int numSlots = 0;
        if (inv.contains(Material.SHULKER_BOX)) {
            numSlots = numSlots + 5;
        }
        if (inv.contains(Material.RED_SHULKER_BOX)) {
            numSlots = numSlots + 10;
        }
        if (inv.contains(Material.PURPLE_SHULKER_BOX)) {
            numSlots = numSlots + 20;
        }
        if (numSlots > 0) {
            for (int x = 35; x > 35 - numSlots; x--) {
                inv.setItem(x, new ItemStack(Material.AIR));
            }
        }
    }

}
