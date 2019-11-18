package com.example.java8.lambda.test;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 11:00
 */
public class FlyableDemo {
    public static void main(String[] args) {
        fly(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("飞机自驾游");
            }
        });
        fly((String s)->{
            System.out.println(s);
        });

    }

    private static void fly(Flyable flyable){
        flyable.fly("111");
    }

}
