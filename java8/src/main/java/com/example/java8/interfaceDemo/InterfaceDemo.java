package com.example.java8.interfaceDemo;

/**
 * Created by duan on 2020/1/7 9:12
 * 不断演进的Java api
 * java 8 中可以定义静态的方法和 默认方法
 */
public interface InterfaceDemo {

    /**
     * 接口中的静态方法
     */
    static void hello() {
        System.out.println("hello 我是接口中的一个静态方法");
    }


    /**
     * 接口中的默认方法
     * 如果实现类不显式提供方法的集体实现，则会自动继承此方法的默认实现
     */
    default void testDefaultMethod() {
        System.out.println("接口中的默认方法");
    }

}
