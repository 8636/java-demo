package com.example.java8.lambda;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.hibernate.validator.constraints.EAN;

import java.util.ArrayList;
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
        Apple apple = new Apple("red","hfs",160);
        Apple apple1 = new Apple("green","hn",120);
        Apple apple2 = new Apple("green","hfs",155);
        apples.add(apple);
        apples.add(apple1);
        apples.add(apple2);
//        List<Apple> apples1 = filterGreenApple(apples);
        List<Apple> apples1 = filterGreenAppleByPredicate(apples,(Apple apple3)->{
            return "green".equals(apple3.getColor()) && apple3.getWeight() > 150;
        });
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

    private static List<Apple> filterGreenAppleByPredicate(List<Apple> appleList,ApplePredicate ap) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (Apple apple : appleList) {
            if (ap.test(apple)) {
                apples.add(apple);
            }
        }
        return apples;
    }

}
