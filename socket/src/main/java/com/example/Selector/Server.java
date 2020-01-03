package com.example.Selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by duan on 2019/12/31 14:16
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1 创建服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(10000));
        //3 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        // 服务器通道不提供数据的传输, 只进行客户端状态的监控
        // 将服务器通道注册到选择器上，表示当前通道准备就绪  可以连接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //4 监听是否有客户端连接
        while (true) {
            int count = selector.select();
            if (count != 0) {
                // 遍历绑定到当前选择器的 令牌列表
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //接受连接
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        // 服务端延伸通道 进行与客户端通道数据的传输
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        // 将延伸通道注册到选择器上，标识当前通道处于可读状态
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        // 通道可读
                    } else if (selectionKey.isReadable()) {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        int len;
                        while ((len = channel.read(byteBuffer)) > 0) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, len));
                            byteBuffer.clear();
                        }
                        System.out.println(selectionKey.isWritable());
                        channel.write(ByteBuffer.wrap("服务端已收到数据".getBytes()));
                    }
                    iterator.remove();
                }
            }
        }
    }
}
