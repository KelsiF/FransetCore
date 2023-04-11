package org.kelsi;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.*;
import org.kelsi.other.christmas;

import java.util.Objects;


public final class fransetcore extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
        // Plugin startup logic
        //for(Player player : Bukkit.getOnlinePlayers()) {
        //public List<String> disabled_users = new ArrayList<String>();
        getServer().getPluginManager().registerEvents(this, this);
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new broadcastCommand());
        getCommand("me").setExecutor(new meCommand());
        getCommand("do").setExecutor(new doCommand());
        getCommand("try").setExecutor(new tryCommand());
        getCommand("roll").setExecutor(new rollCommand());

       // }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

   /* @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.BOLD + "Пожалуйста, ознакомтесь перед игрой с нашими правилами, используя команду: \n" + ChatColor.UNDERLINE + "/rules");
        player.sendMessage(ChatColor.GRAY + "В случае, если вы уже ознакомились с правилами, чтобы отключить это уведомление используйте команду \n" + ChatColor.UNDERLINE + "/rules off");

    } */

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.AIR) {
            System.out.println("you break block by hand");
            event.setCancelled(true);
        }

    }


}
