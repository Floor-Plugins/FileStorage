package com.floorplugins.filestorage;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import com.floorplugins.filestorage.util.HexUtils;

public class HexChunk {
    public static final int DATA_Z = -60;
    private final Chunk chunk;

    public HexChunk(Chunk chunk) {
        this.chunk = chunk;
    }

    private static final Material[] PALETTE = {
            Material.WHITE_WOOL, Material.ORANGE_WOOL, Material.MAGENTA_WOOL, Material.LIGHT_BLUE_WOOL,
            Material.YELLOW_WOOL, Material.LIME_WOOL, Material.PINK_WOOL, Material.GRAY_WOOL,
            Material.LIGHT_GRAY_WOOL, Material.CYAN_WOOL, Material.PURPLE_WOOL, Material.BLUE_WOOL,
            Material.BROWN_WOOL, Material.GREEN_WOOL, Material.RED_WOOL, Material.BLACK_WOOL
    };

    public void setHexChar(int index, char hex) {
        int value = HexUtils.fromHexChar(hex);
        int x = index % 16;
        int z = (index / 16) % 16;
        int y = DATA_Z;
        chunk.getBlock(x, y, z).setType(PALETTE[value]);
    }

    public char getHexChar(int index) {
        int x = index % 16;
        int z = (index / 16) % 16;
        int y = DATA_Z;
        Material mat = chunk.getBlock(x, y, z).getType();

        for (int i = 0; i < PALETTE.length; i++) {
            if (PALETTE[i] == mat)
                return HexUtils.toHexChar(i);
        }

        return '0';
    }

    public int getMaxHexChars() {
        return 16 * 16;
    }

    public Chunk getChunk() {
        return chunk;
    }

    public World getWorld() {
        return chunk.getWorld();
    }
}
