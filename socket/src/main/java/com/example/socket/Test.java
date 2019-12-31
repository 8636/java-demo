package com.example.socket;

import java.io.*;
import java.net.*;

/**
 * Created by duan on 2019/12/13 9:42
 */
public class Test {
    public static void main(String[] args) throws IOException {

        InetAddress localHost = InetAddress.getLocalHost();
        InetAddress[] allByName = InetAddress.getAllByName("www.baidu.com");
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(new String(byName.getAddress()));
        System.out.println(localHost);
        run hello = new run("hello");
        Socket socket = new Socket();
        boolean connected = socket.isConnected();
        socket.connect(new InetSocketAddress("127.0.0.1",2000));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(new String("hello").getBytes());
        outputStream.flush();

        boolean connected1 = socket.isConnected();
        hello.run();
    }


    private static class run {
        String msg;

        public run(String msg) {
            this.msg = msg;
        }

        private void run() {
            System.out.println(msg);
        }

    }
}
