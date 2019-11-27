package com.example.java8.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 14:00
 */
public class StreamDemo {
    public static void main(String[] args) throws JsonProcessingException {
        ArrayList<Apple> apples = new ArrayList<>();
        Apple apple = new Apple("red", "hfs", 160);
        Apple apple1 = new Apple("green", "hn", 120);
        Apple apple2 = new Apple("green", "hfs", 155);
        List<Apple> appleList = Arrays.asList(apple, apple1, apple2);
//        List<Apple> apples1 = filterGreenApple(apples);
        List<Apple> apples1 = filterByPredicate(appleList, (Apple apple3) -> "red".equals(apple3.getColor()));
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(apples1);
        System.out.println(s);
    }

    private static List<Apple> filterGreenApple(List<Apple> appleList) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (Apple apple : appleList) {
            if ("green".equals(apple.getColor())) {
                apples.add(apple);
            }
        }
        return apples;
    }


    /**
     * 泛型方法， 如果没有这个<T>的定义，
     * 在后面参数中使用泛型就会报错。可以认为是一种约定，
     * 当然这个泛型T 还可以写成一些类的子类。
     * <T extends FatherClass>
     *
     * @param list
     * @param ap
     * @param <T>
     * @return
     */
    private static <T> List<T> filterByPredicate(List<T> list, ApplePredicate<T> ap) {
        List<T> apples = new ArrayList<T>();
        for (T e : list) {
            if (ap.test(e)) {
                apples.add(e);
            }
        }
        return apples;
    }
}
