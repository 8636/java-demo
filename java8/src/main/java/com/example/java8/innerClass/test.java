package com.example.java8.innerClass;

import lombok.val;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/2 19:12
 */
public class test {
    public static void main(String[] args) {
        val param = InnerClass.SClass.PARAM;
        System.out.println(param);
    }
}
