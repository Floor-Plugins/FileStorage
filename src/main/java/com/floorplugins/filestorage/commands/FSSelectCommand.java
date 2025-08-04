package com.floorplugins.filestorage.commands;

import com.floorplugins.filestorage.Plugin;
import com.floorplugins.filestorage.Responder;
import com.floorplugins.filestorage.HexChunk;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class FSSelectCommand implements CommandExecutor {
    private final Plugin plugin;

    public FSSelectCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            Responder.sendError(sender, plugin.getConfig().getString("you-must-be-a-player-to-select-chunks"));
            return true;
        }

        HexChunk hexChunk = new HexChunk(p.getLocation().getChunk());
        plugin.getSelectedChunks().add(hexChunk);

        String response = plugin.getConfig().getString("chunk-selected").replaceAll("%", hexChunk.getChunk().getX() + ", " + hexChunk.getChunk().getZ());
        Responder.sendDebug(sender, response);
        return true;
    }
}
