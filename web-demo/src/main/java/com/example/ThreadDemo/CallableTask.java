package com.example.ThreadDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by duan on 2020/1/8 15:08
 */
public class CallableTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(5L);
        return "success";
    }
}
