package com.floorplugins.filestorage.commands;

import com.floorplugins.filestorage.Plugin;
import com.floorplugins.filestorage.Responder;
import com.floorplugins.filestorage.HexChunk;
import com.floorplugins.filestorage.util.HexUtils;
import org.bukkit.command.*;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class FSReadCommand implements CommandExecutor {
    private final Plugin plugin;

    public FSReadCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 2) {
            Responder.sendWarn(sender, "/fsread <offset> <length>");
            return false;
        }

        int offset = Integer.parseInt(args[0]);
        int length = Integer.parseInt(args[1]);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (int i = 0; i < length; i++) {
            int byteIndex = offset + i;
            int hexIndex = byteIndex * 2;
            int chunkIndex = hexIndex / plugin.getSelectedChunks().get(0).getMaxHexChars();
            int localHexIndex = hexIndex % plugin.getSelectedChunks().get(0).getMaxHexChars();

            if (chunkIndex >= plugin.getSelectedChunks().size())
                break;

            HexChunk chunk = plugin.getSelectedChunks().get(chunkIndex);
            char high = chunk.getHexChar(localHexIndex);
            char low = chunk.getHexChar(localHexIndex + 1);
            out.write(HexUtils.hexToByte(high, low));
        }

        Responder.sendDebug(sender, new String(out.toByteArray(), StandardCharsets.UTF_8));
        return true;
    }
}
