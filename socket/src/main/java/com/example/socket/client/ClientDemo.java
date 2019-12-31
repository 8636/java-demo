package com.example.socket.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by duan on 2019/12/20 14:12
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",10000);
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\springboot\\讲义-HTML\\day16\\第16章-秒杀.assets\\Snipaste_2019-10-19_12-35-27.png"));
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        int b;
        while ((b=bis.read())!=-1){
            os.write(b);
        }
        bos.flush();
        socket.shutdownOutput();

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = reader.readLine())!=null){
            System.out.print(line);
        }
        reader.close();
        os.close();
    }
}
