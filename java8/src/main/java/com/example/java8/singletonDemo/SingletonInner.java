package com.example.java8.singletonDemo;

/**
 * Created by duan on 2020/3/24 14:47
 * 静态内部类 单例模式  可以避免静态实例在 类加载阶段就创建
 */
public class SingletonInner {
    private static class Holder{
        private static SingletonInner instance = new SingletonInner();
    }

    private SingletonInner(){}

    public static SingletonInner getInstance(){
        return Holder.instance;
    }
}
