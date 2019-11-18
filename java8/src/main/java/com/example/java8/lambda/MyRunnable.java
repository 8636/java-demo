package com.example.java8.lambda;

/**
 *  lambda  强调做什么  而不是以什么方式 去做
 *
 * @author duan
 * @version 1.0
 * @date 2019/11/18 9:36
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("myRunnable start ......");
    }
}
