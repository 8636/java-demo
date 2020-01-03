package com.example.webdemo.service.impl;

import com.example.webdemo.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:28
 */
@Service("Oracle")
//@Primary // 当ioc容器中存在多个类型相同的bean时，在进行依赖注入时，应指定唯一性
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
