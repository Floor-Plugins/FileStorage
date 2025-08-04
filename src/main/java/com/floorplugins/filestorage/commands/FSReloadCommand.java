package com.floorplugins.filestorage.commands;

import com.floorplugins.filestorage.Plugin;
import com.floorplugins.filestorage.Responder;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class FSReloadCommand implements CommandExecutor {
    private final Plugin plugin;

    public FSReloadCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin.reloadConfig();
        Responder.sendDebug(sender, plugin.getConfig().getString("config-reloaded"));
        return true;
    }
}
