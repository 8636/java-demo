package com.example.socket.server;

import com.alibaba.fastjson.JSON;
import com.example.socket.utils.RedisUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/20 17:05
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(2000);


        System.out.println("服务器准备就绪～");
        System.out.println("服务器信息：" + server.getInetAddress() + " P:" + server.getLocalPort());


        // 等待客户端连接
        for (; ; ) {
            // 得到客户端
            System.out.println("start......");
            //accept方法是阻塞的
            //Listens for a connection to be made to this socket and accepts it.
            //The method blocks until a connection is made
            Socket client = server.accept();
            System.out.println(client);
            // 客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            // 启动线程
            clientHandler.start();
        }

    }

    /**
     * 客户端消息处理
     */
    private static class ClientHandler extends Thread {
        private Socket socket;
        private boolean flag = true;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("新客户端连接：" + socket.getInetAddress() +
                    " P:" + socket.getPort());

            try {
                // 得到打印流，用于数据输出；服务器回送数据使用
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                // 得到输入流，用于接收数据
//                BufferedReader socketInput = new BufferedReader(new InputStreamReader(
//                        socket.getInputStream()));
                InputStream inputStream = socket.getInputStream();

                do {
                    // 客户端拿到一条数据
//                    String str = socketInput.readLine();
                    byte[] bytes = new byte[1];
                    int read = inputStream.read(bytes);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < bytes.length; i++) {
                        stringBuilder.append(bytes[i]);
                    }
                    System.out.println(stringBuilder);
                    String str = new String(bytes, "UTF-8");
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        // 回送
                        socketOutput.println("bye");
                    } else {
                        // 打印到屏幕。并回送数据长度
                        System.out.println(str);
                        Map<String, String> stringStringMap = RedisUtils.hgetAll("TaskHash_" + str);
                        String s = JSON.toJSONString(stringStringMap);
                        socketOutput.println("回送：" + s);
                    }

                } while (flag);

                inputStream.close();
                socketOutput.close();

            } catch (Exception e) {
                System.out.println("连接异常断开");
            } finally {
                // 连接关闭
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("客户端已退出：" + socket.getInetAddress() +
                    " P:" + socket.getPort());

        }
    }
}
