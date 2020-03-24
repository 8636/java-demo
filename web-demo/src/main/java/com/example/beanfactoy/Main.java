package com.example.beanfactoy;

import com.example.LinkedList;

/**
 * Created by duan on 2020/2/17 21:44
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("111");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(3,233);
        System.out.println(linkedList);
    }
}
