/**
 * @author duan
 * @version 1.0
 * @date 2019/12/11 11:47
 */
public class Test1 {
    public static void main(String[] args) {
        String s = "hello world";
        byte[] bytes = s.getBytes();
        int length = bytes.length;
        byte[] bytes1 = toLH(length);
        System.out.println(length);

    }

    private static byte[] toLH(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }
}
