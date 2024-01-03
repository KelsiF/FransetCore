package org.kelsi.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerRespawnEvent;
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
    public void onPlayerSpawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();

        ItemStack slot = new ItemStack(Material.BARRIER);
        slot.setAmount(1);
        ItemMeta slotMeta = slot.getItemMeta();
        slotMeta.setDisplayName(ChatColor.RED + "Слот заблокирован");
        slotMeta.setCustomModelData(10000);

        if (inv.contains(Material.RED_SHULKER_BOX)) {
            for (int x = 9; x <= 17; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        } else if (inv.contains(Material.SHULKER_BOX)) {

            for (int x = 9; x <= 26 - slots; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        } else {
            for (int x = 9; x <= 35; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        }
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnLocationEvent event) {
        Player player = event.getPlayer();
        Inventory inv = player.getInventory();

        ItemStack slot = new ItemStack(Material.BARRIER);
        slot.setAmount(1);
        ItemMeta slotMeta = slot.getItemMeta();
        slotMeta.setDisplayName(ChatColor.RED + "Слот заблокирован");
        slotMeta.setCustomModelData(10000);

        if (inv.contains(Material.RED_SHULKER_BOX)) {
            for (int x = 9; x <= 17; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        } else if (inv.contains(Material.SHULKER_BOX)) {

            for (int x = 9; x <= 26 - slots; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        }
        else {
            for (int x = 9; x <= 35; x++) {
                slotMeta.setLore(Arrays.asList(ChatColor.WHITE + "Чтобы разблокировать, ", ChatColor.WHITE + "купите рюкзак.", "id: " + x));
                slot.setItemMeta(slotMeta);
                inv.setItem(x, slot);
            }
        }
    }

    @EventHandler
    public void onItemInteract(InventoryClickEvent event) {
        int slot = event.getSlot();
        String item = event.getWhoClicked().getInventory().getItem(slot).getItemMeta().getDisplayName();
        if (item != null) {
            if (item.equalsIgnoreCase(ChatColor.RED + "Слот заблокирован")) {
                event.setCancelled(true);
                plugin.getLogger().info("Клик на барьер");
            }
        }
    }

    @EventHandler
    public void onInventoryEvent(InventoryOpenEvent event) {
        Inventory inv = event.getInventory();
        if (inv.getType().equals(InventoryType.PLAYER)) {
            if (inv.contains(Material.PURPLE_SHULKER_BOX)) {
                for (int x = 9; x <= 35; x++) {
                    inv.setItem(x, new ItemStack(Material.AIR));
                }
            }
            if (inv.contains(Material.RED_SHULKER_BOX)) {
                for (int x = 18; x <= 35; x++) {
                    inv.setItem(x, new ItemStack(Material.AIR));
                }
            } else if (inv.contains(Material.SHULKER_BOX)) {

                for (int x = 27; x <= 35 - slots; x++) {
                    inv.setItem(x, new ItemStack(Material.AIR));
                }
            }
        }
    }
}
