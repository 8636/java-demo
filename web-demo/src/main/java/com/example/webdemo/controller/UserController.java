package com.example.webdemo.controller;

import com.example.webdemo.exception.RedisConnException;
import com.example.webdemo.service.UserService;
import com.example.webdemo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:30
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

//    @GetMapping("/hello")
//    public String test() throws Exception{
//        RedisUtils.getjedisFromPool();
//        System.out.println("111");
//        return "111";
//    }


}
