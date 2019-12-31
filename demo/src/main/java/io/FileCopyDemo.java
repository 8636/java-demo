package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/10 14:37
 */
public class FileCopyDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileInputStream fileInputStream = new FileInputStream("D:\\test.md");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test\\ceshi.md");
        int available = fileInputStream.available();
        System.out.println(available);
        byte[] bytes = new byte[1024];
        int len;
        while ((len =fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
            System.out.println(len);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }
}
