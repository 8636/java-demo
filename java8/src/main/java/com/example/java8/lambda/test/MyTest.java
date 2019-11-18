package com.example.java8.lambda.test;

import com.sun.xml.internal.stream.events.DummyEvent;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 9:44
 */
public class MyTest {
    public static void main(String[] args) {
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("111111");
            }
        });
        EatableImpl eatable = new EatableImpl();
        useEatable(eatable);
        useEatable(()->{
            System.out.println("2222");
        });


    }

    public static void useEatable(Eatable eatable){
        eatable.eat();
    }
}
