package com.example.Scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by duan on 2020/1/3 14:27
 */
@Component
public class TestSchedule {
    @Scheduled(cron = "0/3 * * * * ?")
    public void task01() {
        System.out.println(Thread.currentThread().getName() + "----> task01");
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void task02() {
        System.out.println(Thread.currentThread().getName() + "----> task02");
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void task03() {
        System.out.println(Thread.currentThread().getName() + "----> task03");
    }

}
