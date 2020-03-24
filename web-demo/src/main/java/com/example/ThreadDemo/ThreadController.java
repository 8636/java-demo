package com.example.ThreadDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by duan on 2020/1/7 14:36
 */
@RestController
public class ThreadController {
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            // 核心线程数 在池中不消失的
            2,
            // 池中最大可容纳的线程数  核心线程 + 非核心线程
            // 当等待队列满了，如果当前线程数没有超过最大线程数，则会新建线程执行任务
            4,
            // 空闲时 线程存活时间 线程空闲下来之后，保持存活的持续时间，超过这个时间还没有任务执行，该工作线程结束
            50,
            // 时间单位
            TimeUnit.SECONDS,
            // 阻塞队列 新任务到达时，核心线程全部被占用，新任务存储在该队列中，当核心线程空闲时，会从该队列中拉取任务执行
            new ArrayBlockingQueue<>(3),
            // 线程创建工厂
            Executors.defaultThreadFactory(),
            // 任务的拒绝策略
            // 1、何时拒绝： 提交任务数量 > 线程池最大容量 + 阻塞队列的容量
            // 2、如何拒绝： CallerRunsPolicy 绕过线程池 直接调用线程的run方法
            //              AbortPolicy      直接拒绝 并抛出异常
            //            * 任务拒绝策略
            //            *  1、AbortPolicy    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
            //            *  2、DiscardPolicy  直接拒绝 不抛出异常
            //            *  3、DiscardOldestPolicy 移除任务队列中的等待时间最久的任务，将新任务加入任务队列
            //            *  4、CallerRunsPolicy  直接绕过线程池  调用run方法，利用的main线程
                /*
                pool-1-thread-5执行了
                main执行了
                pool-1-thread-1执行了
                main执行了
                */
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );


    @RequestMapping("/run")
    public void run(){
        pool.submit(()->{
            int i = 0 ;
            while (i < 10){
                i++;
                String name = Thread.currentThread().getName();
                System.out.println(name +  "--i=" +  i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程" + Thread.currentThread().getName() + "结束" + i + "--当前池中线程数为" + pool.getPoolSize());
            BlockingQueue<Runnable> queue = pool.getQueue();
            System.out.println("阻塞队列中的任务数量为" + queue.size());
        });
    }


    @RequestMapping("/call")
    @ResponseBody
    public void call(){
        ExecutorService threadpool = null;
        try {
            threadpool = Executors.newFixedThreadPool(3);
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            System.out.println("提交一个callable任务到线程池，现在时间是：" + sdf.format(new Date()));
            Future<String> future = threadpool.submit(new CallableTask());
            System.out.println("获取callable任务的结果：" + future.get() + "，现在时间是：" + sdf.format(new Date()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (threadpool != null) {
                threadpool.shutdown();
            }
        }
    }
}
