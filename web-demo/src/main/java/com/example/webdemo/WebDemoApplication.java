package com.example.webdemo;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
// spring默认扫描启动类目录及其子包下的组件，其他包下的组件需要componentScan 注解
@ComponentScan({"com.example.Scheduling", "com.example.ThreadDemo","com.example.webdemo"})

@SpringBootApplication
@EnableScheduling
public class WebDemoApplication {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(args));
        SpringApplication.run(WebDemoApplication.class, args);
    }

    @Bean
    public TaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        taskScheduler.setThreadNamePrefix("Springboot-taskDemo");
        return taskScheduler;
    }
}
