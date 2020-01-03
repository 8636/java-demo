package com.example.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by duan on 2019/12/31 14:27
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 10000));
        ByteBuffer byteBuffer = ByteBuffer.wrap("hello nio server over".getBytes());
        socketChannel.write(byteBuffer);
//        socketChannel.shutdownOutput();

        System.out.println("客户端发送数据完成");
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int len;
        while ((len = socketChannel.read(buffer)) != -1) {
            System.out.println("开始读取服务端的数据");
            buffer.flip();
            System.out.println(new String(buffer.array(), 0, len));
            buffer.clear();
        }
        socketChannel.close();
    }
}
