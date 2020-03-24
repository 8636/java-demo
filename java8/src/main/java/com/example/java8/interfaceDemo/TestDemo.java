package com.example.java8.interfaceDemo;

/**
 * Created by duan on 2020/1/7 9:18
 */
public class TestDemo {
    public static void main(String[] args) {
        InterfaceDemoImpl interfaceDemo = new InterfaceDemoImpl();
        InterfaceDemo.hello();
        interfaceDemo.testDefaultMethod();


    }
}
