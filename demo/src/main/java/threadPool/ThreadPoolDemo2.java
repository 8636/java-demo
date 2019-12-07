package threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/** 手动创建 线程池
 * @author duan
 * @version 1.0
 * @date 2019/12/7 19:35
 */
public class ThreadPoolDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                // 核心线程数 在池中不消失的
                5,
                // 池中最大可容纳的线程数
                20,
                // 空闲时 线程存活时间
                60,
                // 时间单位
                TimeUnit.SECONDS,
                // 阻塞队列
                new ArrayBlockingQueue<>(10),
                // 线程创建工厂
                Executors.defaultThreadFactory(),
                // 拒绝策略
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < 300; i++) {
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "执行了");
            });
            Thread.sleep(20);
        }


    }
}