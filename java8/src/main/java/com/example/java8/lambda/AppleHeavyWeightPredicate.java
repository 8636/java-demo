package com.example.java8.lambda;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/18 14:20
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
