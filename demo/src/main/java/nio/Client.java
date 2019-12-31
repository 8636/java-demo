package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by duan on 2019/12/17 14:08
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 10; i++) {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);
            if (!socketChannel.connect(inetSocketAddress)) {
                while (!socketChannel.finishConnect()) {
                    System.out.println("未完成连接。。");
                    continue;
                }
            }
            String str = "hello server" + i;
            ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
            socketChannel.write(wrap);
            Thread.sleep(2000);
        }

    }
}
