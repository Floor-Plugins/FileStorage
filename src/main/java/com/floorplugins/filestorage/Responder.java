package com.floorplugins.filestorage;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;

public class Responder {
    private static BukkitAudiences adventure;
    private static Plugin plugin;

    public static void init(BukkitAudiences audiences, Plugin pluginInstance) {
        adventure = audiences;
        plugin = pluginInstance;
    }

    public static void sendDebug(CommandSender sender, String message) {
        sendMessage(sender,
                Component.text(message).color(TextColor.color(plugin.getConfig().getInt("message-color-normal"))));
    }

    public static void sendWarn(CommandSender sender, String message) {
        sendMessage(sender,
                Component.text(message).color(TextColor.color(plugin.getConfig().getInt("message-color-warning"))));
    }

    public static void sendError(CommandSender sender, String message) {
        sendMessage(sender,
                Component.text(message).color(TextColor.color(plugin.getConfig().getInt("message-color-error"))));
    }

    private static void sendMessage(CommandSender sender, Component message) {
        if (adventure != null) {
            adventure.sender(sender).sendMessage(Component.text(plugin.getConfig().getString("message-prefix"))
                    .color(TextColor.color(plugin.getConfig().getInt("message-prefix-color"))).append(message));
        } else {
            sender.sendMessage(plugin.getConfig().getString("message-prefix") + message);
        }
    }
}
