package com.example.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by duan on 2020/1/3 17:01
 */
public class StreamDemo {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1299999", "126", "12222","3","");
//        List<String> integers = list.stream().filter(s -> s.length() > 1)
//                .sorted((s1,s2)->s2.length() - s1.length())
//                .collect(Collectors.toList());
//        System.out.println("----");

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );


        // filter map limit 等操作返回的是stream  在collect之前没有结果产生
        List<String> threeHighCaloricDishNames = menu.stream()
                //接受Lambda，从流中排除某些元素
                .filter(d -> d.getCalories() > 300)
                //接受一个Lambda，将元素转换成其他形式或提取信息
                .map(Dish::getName)
                //截断流，使其元素不超过给定数量
                .limit(10)
                //将流转换为其他形式
                .collect(toList());
        System.out.println(threeHighCaloricDishNames);



        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        List<String> stringList = words.stream().map(i -> i.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(wordLengths.toString());
        System.out.println(stringList.toString());
    }
}
