package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by duan on 2019/12/31 14:16
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {

        //1 创建服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2 绑定端口
        serverSocketChannel.bind(new InetSocketAddress(10000));
        //3 设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //4 监听是否有客户端连接
        while (true) {
            //5 获得延伸通道 分配缓冲区 进行读数据
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null){
                System.out.println("有客户端连接" + socketChannel.getRemoteAddress());
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                int len;
                Thread.sleep(1000);
                while ((len = socketChannel.read(byteBuffer)) > 0){
                    //6 切换读写模式 客户端写数据  原路返回
                    System.out.println("开始从缓冲区读数据");
                    // 添加数据---> 获取数据  flip方法
                    // 获取数据---> 添加数据  clean方法
                    byteBuffer.flip();
                    System.out.println(new String(byteBuffer.array(),0,len));
                    byteBuffer.clear();
                }
                System.out.println("接受数据完毕，开始向客户端回写数据");
                socketChannel.write(ByteBuffer.wrap("已收到数据 over".getBytes()));
                System.out.println("回写数据完毕");
                socketChannel.close();
            }
        }

    }
}
