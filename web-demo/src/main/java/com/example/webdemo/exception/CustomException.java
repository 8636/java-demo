package com.example.webdemo.exception;


import com.example.webdemo.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 10:00
 */
@Data
@AllArgsConstructor
public class CustomException extends Exception {
    private String message;

    private Integer code;

    public CustomException(String message){
        this.message = message;
    }

    public CustomException(Integer code){
        this.code = code;
    }

    public CustomException(StatusEnums statusEnums) {
        this.message = statusEnums.getInfo();
        this.code = statusEnums.getCode();
    }
}
