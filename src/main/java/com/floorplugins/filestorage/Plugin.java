package com.floorplugins.filestorage;

import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;

import java.util.*;

import com.floorplugins.filestorage.commands.*;

public class Plugin extends JavaPlugin {
    private final List<HexChunk> selectedChunks = new ArrayList<>();
    private BukkitAudiences adventure;

    public List<HexChunk> getSelectedChunks() {
        return selectedChunks;
    }

    @Override
    public void onEnable() {
        // Config
        saveDefaultConfig();

        // Responder
        adventure = BukkitAudiences.create(this);
        Responder.init(adventure, this);

        // Commands
        register("fsreload", new FSReloadCommand(this));
        register("fsselect", new FSSelectCommand(this));
        register("fsread", new FSReadCommand(this));
        register("fswrite", new FSWriteCommand(this));
    }

    @Override
    public void onDisable() {
        if (adventure != null) {
            adventure.close();
        }
    }

    private void register(String cmd, Object executor) {
        PluginCommand command = getCommand(cmd);

        if (command != null)
            command.setExecutor((org.bukkit.command.CommandExecutor) executor);
    }
}
