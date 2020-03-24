package com.example.java8.singletonDemo;

import java.io.Serializable;

/**
 * Created by duan on 2020/3/24 14:40
 *
 * 单例模式 懒汉式  双重检查锁
 *
 * 使用反射强行调用私有构造器，解决方式可以修改构造器，让它在创建第二个实例的时候抛异常
 */
public class Singleton implements Serializable {

    // volatile 1、内存可见性 2、禁止指令重排序优化
    private static volatile Singleton instance = null;

    private Singleton(){}


    public static Singleton getInstance(){
        //在加锁前进行一次 null值检查  可以减少大多数的加锁操作
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
