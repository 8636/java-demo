package com.example.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by duan on 2019/12/20 14:17
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 监听2000端口
        ServerSocket serverSocket = new ServerSocket(2000);
        while (true){
            System.out.println("--");
            Socket socket = serverSocket.accept();
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("socket\\file\\" + UUID.randomUUID() + ".jpg"));
            int b;
            // 关流的时候 会写入终止符号
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("上传成功".getBytes());
            outputStream.flush();
            outputStream.close();
            bos.close();
            bis.close();
        }
    }
}
