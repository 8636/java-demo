package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Created by duan on 2019/12/17 11:21
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        String str = "nio  hello ";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("test.txt");
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        System.out.println("----");

    }

}
