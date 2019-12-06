package com.example.webdemo.exception;


import com.example.webdemo.model.ResponseDTO;
import com.example.webdemo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/** 统一异常处理类
 * @author duan
 * @version 1.0
 * @date 2019/11/7 11:14
 */
@ControllerAdvice
@Slf4j
public class RequestExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    void tokenAndParams(Exception e) {
        log.info("进入全局异常处理类");
        ResponseDTO responseCode = null;
        if (e instanceof RedisConnException) {
            RedisConnException exception = (RedisConnException) e;
            responseCode = new ResponseDTO("1", exception.getMessage());
        }
        JsonUtils.responseJson(responseCode);
    }


    @ExceptionHandler(CustomException.class)
    @ResponseBody
    void customExceptionHandle(Exception e) {
        ResponseDTO responseCode = null;
        if (e instanceof CustomException) {
            CustomException exception = (CustomException) e;
            responseCode = new ResponseDTO("1", exception.getMessage());
        }
        JsonUtils.responseJson(responseCode);
    }
}
