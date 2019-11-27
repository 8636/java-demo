package com.example.webdemo.service.impl;

import com.example.webdemo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:27
 */

public class MysqlUserServiceImpl implements UserService {
    @Override
    public String print() {
        return "mysql ....";
    }

    @Override
    public String hello() {
        return "MySQL hello....";
    }
}
