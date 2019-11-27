package com.example.java8.funnction;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/19 9:14
 */
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
