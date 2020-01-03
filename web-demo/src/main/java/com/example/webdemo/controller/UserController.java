package com.example.webdemo.controller;

import com.example.webdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/27 9:30
 */
@Controller
public class UserController {

//    @Autowired
//    @Qualifier("mysql")
    @Resource(name = "mysql")
    UserService userService;

//    @GetMapping("/hello")
//    public String test() throws Exception{
//        RedisUtils.getjedisFromPool();
//        System.out.println("111");
//        return "111";
//    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity test(){
        userService.hello();
        return ResponseEntity.ok("hello");

    }

    @PostMapping("/post")
    @ResponseBody
    public void post(){
        System.out.println("post");
    }

    @GetMapping("/get")
    @ResponseBody
    public void get(){
        System.out.println("get");
    }

    @PutMapping("/put")
    @ResponseBody
    public void put(){
        System.out.println("put");
    }


    @DeleteMapping("/delete")
    @ResponseBody
    public void delete(){
        System.out.println("delete");
    }


    @GetMapping("/getView")
    public String getView(){
        return "hello";
    }





}
