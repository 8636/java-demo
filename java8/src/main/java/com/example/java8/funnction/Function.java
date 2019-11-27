package com.example.java8.funnction;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/19 9:01
 */
@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
