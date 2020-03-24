package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** 手动创建 线程池
 * 任务拒绝策略
 *  1、AbortPolicy    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
 *  2、DiscardPolicy  直接拒绝 不抛出异常
 *  3、DiscardOldestPolicy 移除任务队列中的等待时间最久的任务，将新任务加入任务队列
 *  4、CallerRunsPolicy  直接绕过线程池  调用run方法，利用的main线程
 *
 * @author duan
 * @version 1.0
 * @date 2019/12/7 19:35
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                // 核心线程数 在池中不消失的
                2,
                // 池中最大可容纳的线程数
                5,
                // 空闲时 线程存活时间
                60,
                // 时间单位
                TimeUnit.SECONDS,
                // 阻塞队列
                new ArrayBlockingQueue<>(5),
                // 线程创建工厂
                Executors.defaultThreadFactory(),
                // 任务的拒绝策略
                // 1、何时拒绝： 提交任务数量 > 线程池最大容量 + 阻塞队列的容量
                // 2、如何拒绝： CallerRunsPolicy 绕过线程池 直接调用线程的run方法
                /*
                pool-1-thread-5执行了
                main执行了
                pool-1-thread-1执行了
                main执行了
                */
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 300; i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "执行了");
            });
        }
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int i = atomicInteger.incrementAndGet();


    }
}