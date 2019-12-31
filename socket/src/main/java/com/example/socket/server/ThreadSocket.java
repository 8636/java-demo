package com.example.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.UUID;

/**
 * Created by duan on 2019/12/23 19:49
 */
public class ThreadSocket implements Runnable {
    private Socket socket;

    public ThreadSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        BufferedOutputStream bos = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream("socket\\file\\" + UUID.randomUUID() + ".jpg"));
            int b;
            // 关流的时候 会写入终止符号
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

        } catch (Exception e) {

        } finally {
            if (bos != null) {

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
