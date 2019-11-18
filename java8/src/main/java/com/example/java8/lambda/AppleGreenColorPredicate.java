package com.example.java8.lambda;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 14:18
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    /**
     * 筛选出 绿色的苹果
     * @param apple
     * @return
     */
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
