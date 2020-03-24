package com.example.java8.enumDemo;

import java.util.Arrays;

/**
 * Created by duan on 2020/3/24 14:13
 */
public class EnumDemo {

    public static void main(String[] args) {

        Day day = Day.FRIDAY;
        System.out.println(day);
        System.out.println(day instanceof Day);
        System.out.println(day.ordinal());
        System.out.println(day.name());
        Arrays.stream(Day.values()).forEach(System.out::println);
    }
}
