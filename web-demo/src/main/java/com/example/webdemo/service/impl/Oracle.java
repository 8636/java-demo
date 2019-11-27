package com.example.webdemo.service.impl;

import com.example.webdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:28
 */
@Service
public class Oracle implements UserService {
    @Override
    public String print() {
        return "Oracle....";
    }

    @Override
    public String hello() {
        return "hello Oracle...";
    }
}
