package com.example.java8.lambda.test;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 11:17
 */
public class PrintableDemo {
    public static void main(String[] args) {
        print((String s)->{
            System.out.println(s);
        });

        print(s -> System.out.println(s));

        print(System.out::println);
    }

    private static void print(Printable p){
        p.printable("java");
    }
}
