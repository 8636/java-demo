package com.example.webdemo.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by duan on 2019/12/30 10:27
 */
public class TestOKhttp {
    public static void main(String[] args) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            System.out.println(response.body().toString());
        }
    }
}
