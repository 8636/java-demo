import ch.qos.logback.core.encoder.ByteArrayUtil;

import java.util.Arrays;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 13:52
 */
public class TestByte {
    public static void main(String[] args) {
        byte[] bytes = {-96, -125, 0, 0};
        byte[] bytes1 = {0, 0, 17, -70};
        byte[] bytes2 = new byte[4];
        for (int i = 0, j = bytes.length - 1; i < bytes.length; i++, j--) {
            bytes2[j] = bytes[i];
        }
        int m = byteArrayToInt(bytes2);
        System.out.println("----" + m);
        int i4 = byteToInt(bytes);
        int i1 = byteArrayToInt(bytes1);
        System.out.println(i4);
        System.out.println(i1);
    }

    private static int byteToInt(byte[] bytes) {
        byte[] tempBytes = new byte[4];
        tempBytes[0] = bytes[3];
        int i1 = ((Byte) tempBytes[0]).intValue();
        if (i1 < 0) {
            i1 = (1 << 8) + i1;
        }
        tempBytes[1] = bytes[2];
        int i2 = ((Byte) tempBytes[1]).intValue();
        if (i2 < 0) {
            i2 = (1 << 8) + i2;
        }
        tempBytes[2] = bytes[1];
        int i3 = ((Byte) tempBytes[2]).intValue();
        if (i3 < 0) {
            i3 = (1 << 8) + i3;
        }
        tempBytes[3] = bytes[0];
        int i4 = ((Byte) tempBytes[3]).intValue();
        if (i4 < 0) {
            i4 = (1 << 8) + i4;
        }
        return (i1 << 24) + (i2 << 16) + (i3 << 8) + i4;
    }


    public static int byteArrayToInt(byte[] b) {
        return b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }
}
