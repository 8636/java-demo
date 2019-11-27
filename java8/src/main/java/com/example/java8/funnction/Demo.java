package com.example.java8.funnction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 接受一个 泛型为 T的对象   返回一个泛型为 R 的对象
 * @author duan
 * @version 1.0
 * @date 2019/11/19 9:02
 */
public class Demo {
    public static void main(String[] args) throws JsonProcessingException {
//        List<Integer> map = map(Arrays.asList("lambda", "java", "python"), (String s) -> s.length());
        List<Integer> map = map(Arrays.asList("lambda", "java", "python"), String::length);
        String s = new ObjectMapper().writeValueAsString(map);
        System.out.println(s);

        foreach(Arrays.asList("1","a","6","0","5"),System.out::println);

    }


    public static <T,R> List<R> map(List<T> list ,Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static <T> void foreach(List<T> list ,Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
