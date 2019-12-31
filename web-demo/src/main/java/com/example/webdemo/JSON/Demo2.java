package com.example.webdemo.JSON;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by duan on 2019/12/19 14:16
 */
public class Demo2 {
    public static void main(String[] args) throws JsonProcessingException {
        UserDemo duan = new UserDemo("duan", "123");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(duan);
        System.out.println(s);

    }
}
