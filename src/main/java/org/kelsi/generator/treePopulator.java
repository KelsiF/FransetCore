package org.kelsi.generator;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class treePopulator extends BlockPopulator {


    @Override
    public void populate(@NotNull World world, @NotNull Random random, @NotNull Chunk chunk) {
        if (random.nextBoolean()) {
            int amount = random.nextInt(4)+1;  // Amount of trees
            for (int i = 1; i < amount; i++) {
                int X = random.nextInt(16);
                int Z = random.nextInt(16);
                int Y;
                for (Y = world.getMaxHeight(); chunk.getBlock(X, Y, Z).getType() == Material.AIR; Y--); // Find the highest block of the (X,Z) coordinate chosen.
                world.generateTree(chunk.getBlock(X, Y, Z).getLocation(), TreeType.BIG_TREE); // The tree type can be changed if you want.
            }
        }
    }
}
