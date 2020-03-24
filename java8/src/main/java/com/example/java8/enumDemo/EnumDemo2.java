package com.example.java8.enumDemo;

/**
 * Created by duan on 2020/3/24 14:27
 *
 * 美剧
 */
public enum EnumDemo2 {
    FIRST{
        @Override
        public String getInfo() {
            return "first";
        }
    },
    SECOND{
        @Override
        public String getInfo() {
            return "second";
        }
    };

    public abstract String getInfo();


    public static void main(String[] args) {
        System.out.println(EnumDemo2.FIRST);
        System.out.println(EnumDemo2.FIRST.getInfo());
        System.out.println(EnumDemo2.FIRST.name());
    }
}
