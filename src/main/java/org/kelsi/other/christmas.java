package org.kelsi.other;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class christmas implements CommandExecutor {

    public christmas() {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args)  {

        Player player = (Player) sender;

        LivingEntity entity = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);

        Zombie zombie = (Zombie) entity;
        double hp_christmas = zombie.getHealth();
        zombie.setCustomName("Призрак Нового года");
        zombie.setCustomNameVisible(true);
        zombie.setMaxHealth(100);
        zombie.setHealth(100);
        zombie.getEquipment().setHelmet(new ItemStack(Material.SNOW_BLOCK));
        zombie.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        zombie.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        zombie.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));

        return true;
    }

}
