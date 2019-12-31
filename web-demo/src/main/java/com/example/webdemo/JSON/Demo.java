package com.example.webdemo.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Demo {
    public static void main(String[] args) {
        User user = new User("zhangsan","123");
        String s = JSON.toJSONString(user);
        System.out.println(s);
        UserDemo userDemo = new UserDemo("duan", "123456");
        String s1 = JSONObject.toJSONString(userDemo);
        System.out.println(s1);
    }
}
