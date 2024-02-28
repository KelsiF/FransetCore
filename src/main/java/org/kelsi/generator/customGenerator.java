package org.kelsi.generator;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.PerlinNoiseGenerator;
import org.bukkit.util.noise.PerlinOctaveGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class customGenerator extends ChunkGenerator {
    int currentHeight = 50;

    @Override
    public @NotNull ChunkData generateChunkData(World world, @NotNull Random random, int chunkX, int chunkZ, @NotNull BiomeGrid biome) {
        //SimplexOctaveGenerator generator = new SimplexOctaveGenerator(new Random(world.getSeed()), 8);
        PerlinOctaveGenerator generator = new PerlinOctaveGenerator(new Random(world.getSeed()), 16);
        ChunkData chunk = createChunkData(world);
        generator.setScale(0.008D);
        //generator.setScale(0.005D);

        for (int X = 0; X < 16; X++)
            for (int Z = 0; Z < 16; Z++) {
                currentHeight = (int) (generator.noise(chunkX*16+X, chunkZ*16+Z, 0.5D, 0.5D)*15D+50D);
                if (currentHeight > 60) {
                    chunk.setBlock(X, currentHeight, Z, Material.GRASS_BLOCK);
                } else {
                    chunk.setBlock(X, currentHeight, Z, Material.WATER);
                }
                chunk.setBlock(X, currentHeight-1, Z, Material.DIRT);
                for (int i = currentHeight-2; i > 0; i--)
                    chunk.setBlock(X, i, Z, Material.STONE);
                chunk.setBlock(X, 0, Z, Material.BEDROCK);
            }
        return chunk;
    }

    @Override
    public @NotNull List<BlockPopulator> getDefaultPopulators(@NotNull World world) {
        return Arrays.asList(new treePopulator(), new grassPopulator(), new lakePopulator());
    }
}