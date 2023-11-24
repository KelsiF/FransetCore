package org.kelsi;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.kelsi.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


public final class fransetcore extends JavaPlugin implements Listener {

    public static Map<UUID, Integer> rep = new HashMap<>();

    @Override
    public void onEnable(){
        // Plugin startup logic
        //for(Player player : Bukkit.getOnlinePlayers()) {
        //public List<String> disabled_users = new ArrayList<String>();
        getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("broadcast")).setExecutor(new broadcastCommand());
        Objects.requireNonNull(getCommand("me")).setExecutor(new meCommand());
        Objects.requireNonNull(getCommand("do")).setExecutor(new doCommand());
        Objects.requireNonNull(getCommand("try")).setExecutor(new tryCommand());
        Objects.requireNonNull(getCommand("roll")).setExecutor(new rollCommand());
        Objects.requireNonNull(getCommand("setevent")).setExecutor(new seteventCommand(this));
        Objects.requireNonNull(getCommand("removeevent")).setExecutor(new removeeventCommand(this));
        Objects.requireNonNull(getCommand("event")).setExecutor(new eventCommand(this));
        Objects.requireNonNull(getCommand("rep")).setExecutor(new repCommand());
        Objects.requireNonNull(getCommand("world")).setExecutor(new worldCommand());

       // }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!rep.equals(player.getUniqueId())) {
            rep.put(player.getUniqueId(), 500);
        }

        Integer value = rep.get(player.getUniqueId());
        player.sendMessage("ваша порядочность: " + value);
    }


}
