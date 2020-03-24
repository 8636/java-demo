package com.example.java8.singletonDemo;

/**
 * Created by duan on 2020/3/24 14:36
 */
public class SingletonHungry {
    private static SingletonHungry instance = new SingletonHungry();


    //构造函数私有化
    private SingletonHungry(){

    }


    public static SingletonHungry getInstance(){
        return instance;
    }
}
