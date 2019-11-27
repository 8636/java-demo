package com.example.webdemo.exception;


import com.example.webdemo.enums.StatusEnums;
import lombok.Data;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:59
 */
@Data
public class RedisConnException extends Exception {
    private String message;

    private Integer code;

    public RedisConnException(String message){
        this.message = message;
    }

    public RedisConnException(Integer code){
        this.code = code;
    }

    public RedisConnException(StatusEnums statusEnums) {
        this.message = statusEnums.getInfo();
        this.code = statusEnums.getCode();
    }
}
