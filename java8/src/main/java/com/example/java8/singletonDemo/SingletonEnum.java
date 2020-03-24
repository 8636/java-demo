package com.example.java8.singletonDemo;

/**
 * Created by duan on 2020/3/24 14:53
 *单例模式  枚举类型  完全不用考虑序列化和反射的问题
 */
public enum  SingletonEnum {
    INSTANCE;
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
