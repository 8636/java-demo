package com.example.webdemo.controller;

import com.example.webdemo.enums.StatusEnums;
import com.example.webdemo.exception.CustomException;
import com.example.webdemo.exception.TestException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.DataInputStream;
import java.util.Map;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 16:18
 */
@Controller
public class test {

    @GetMapping("/test")
    @ResponseBody
    public String test(Model model) throws TestException {
        Map<String, Object> stringObjectMap = model.asMap();
        System.out.println("111111");
        return "hello https";
    }
}
