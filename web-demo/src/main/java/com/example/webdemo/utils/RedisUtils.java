package com.example.webdemo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 11:33
 */
@Slf4j
@Component
public class RedisUtils {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public static RedisUtils redisUtils;

    /**
     * @PostConstruct注解的方法将会在依赖注入完成后被自动调用
     */
    @PostConstruct
    public void init() {
        log.info("init........");
        redisUtils = this;
        redisUtils.stringRedisTemplate = stringRedisTemplate;
    }

    public static void getjedisFromPool(){
        redisUtils.stringRedisTemplate.opsForValue().set("test", "222");
    }


    public static void test(){
        StringRedisTemplate stringRedisTemplate = SpringUtils.getBean(StringRedisTemplate.class);
        stringRedisTemplate.opsForValue().set("hello", "nihao");
    }

}
