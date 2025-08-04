package com.floorplugins.filestorage.commands;

import com.floorplugins.filestorage.Plugin;
import com.floorplugins.filestorage.Responder;
import com.floorplugins.filestorage.HexChunk;
import com.floorplugins.filestorage.util.HexUtils;
import org.bukkit.command.*;

import java.nio.charset.StandardCharsets;

public class FSWriteCommand implements CommandExecutor {
    private final Plugin plugin;

    public FSWriteCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            Responder.sendWarn(sender, "/fswrite <offset> <text>");
            return false;
        }

        int offset = Integer.parseInt(args[0]);
        byte[] data = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length))
                .getBytes(StandardCharsets.UTF_8);

        for (int i = 0; i < data.length; i++) {
            int byteIndex = offset + i;
            int hexIndex = byteIndex * 2;
            int chunkIndex = hexIndex / plugin.getSelectedChunks().get(0).getMaxHexChars();
            int localHexIndex = hexIndex % plugin.getSelectedChunks().get(0).getMaxHexChars();

            if (chunkIndex >= plugin.getSelectedChunks().size())
                break;

            HexChunk chunk = plugin.getSelectedChunks().get(chunkIndex);
            String hex = HexUtils.byteToHex(data[i]);
            chunk.setHexChar(localHexIndex, hex.charAt(0));
            chunk.setHexChar(localHexIndex + 1, hex.charAt(1));
        }

        String response = plugin.getConfig().getString("wrote-bytes").replaceAll("%", "" + data.length);
        Responder.sendDebug(sender, response);
        return true;
    }
}
