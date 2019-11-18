package com.example.java8.lambda;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 9:34
 */
public class LambdaTest {
    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRunnable()).start();
        new Thread(()->{
            System.out.println("lambda run ....");
        }).start();
    }
}
