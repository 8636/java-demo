package com.example.webdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 16:24
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "not found")
public class TestException extends Exception {
}
