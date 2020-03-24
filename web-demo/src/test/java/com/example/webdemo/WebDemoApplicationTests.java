package com.example.webdemo;

import com.example.factoryBean.Demo;
import com.example.factoryBean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = { Demo.class })
class WebDemoApplicationTests {
    @Autowired
    User user;

    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
