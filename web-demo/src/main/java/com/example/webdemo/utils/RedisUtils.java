package com.example.webdemo.utils;

import com.example.webdemo.enums.StatusEnums;
import com.example.webdemo.exception.RedisConnException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 11:33
 */
@Slf4j
public class RedisUtils {
    public static void getjedisFromPool() throws RedisConnException {
        log.info("start...");
        throw new RedisConnException(StatusEnums.REDIS_CONNECT_ERROR);
    }
}
