package com.example.java8.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/3 8:38
 */
public class ForEachTest {
    public static void main(String[] args) {


//        ArrayList<String> list = new ArrayList<>();
//        list.add("xiaomo");
//        list.add("xiaohong");
//        list.add("liming");
//        for (String s : list) {
//            if ("liming".equals(s)){
//                list.remove(s);
//            }
//        }
//        System.out.println("s");

        HashSet<String> strings = new HashSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
