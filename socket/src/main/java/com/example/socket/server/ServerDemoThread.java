package com.example.socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * Created by duan on 2019/12/20 14:17
 */
public class ServerDemoThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        while (true){
            Socket accept = serverSocket.accept();
            ThreadSocket threadSocket = new ThreadSocket(accept);
            new Thread(threadSocket).start();
        }

    }
}
