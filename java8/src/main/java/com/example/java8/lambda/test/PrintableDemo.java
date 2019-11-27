package com.example.java8.lambda.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 11:17
 */
public class PrintableDemo {
    public static void main(String[] args) {
//        print((String s)->{
//            System.out.println(s);
//        });
//
//        print(s -> System.out.println(s));
//
//        print(System.out::println);

        System.out.println(isPileStop("1480"));
        System.out.println(isPileStop("1430"));
    }

    private static void print(Printable p){
        p.printable("java");
    }

    private static boolean isPileStop(String releaseReason) {
        boolean b = false;
        List<String> list = Arrays.asList("1480", "1490", "1480", "1500", "1510", "1520", "1530", "1540", "1550", "1560", "1570", "1580", "1590");
        if (list.contains(releaseReason)) {
            b = true;
        }
        return b;
    }
}
