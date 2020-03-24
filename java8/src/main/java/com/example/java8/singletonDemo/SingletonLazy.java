package com.example.java8.singletonDemo;

/**
 * Created by duan on 2020/3/24 14:38
 * 单例模式 懒汉式 由于synchronized的存在，效率很低
 */
public class SingletonLazy {
    private static SingletonLazy instance = null;

    private SingletonLazy() {

    }

    public static synchronized SingletonLazy getInstance() {

        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
