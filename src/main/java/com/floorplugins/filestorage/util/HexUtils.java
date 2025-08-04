package com.floorplugins.filestorage.util;

public class HexUtils {
    public static char toHexChar(int value) {
        return "0123456789ABCDEF".charAt(value & 0xF);
    }

    public static int fromHexChar(char c) {
        int val = Character.digit(c, 16);

        if (val == -1)
            throw new IllegalArgumentException("Invalid hex character: " + c);

        return val;
    }

    public static String byteToHex(byte b) {
        int v = b & 0xFF;
        return "" + toHexChar(v >> 4) + toHexChar(v & 0xF);
    }

    public static byte hexToByte(char high, char low) {
        return (byte) ((fromHexChar(high) << 4) | fromHexChar(low));
    }
}
