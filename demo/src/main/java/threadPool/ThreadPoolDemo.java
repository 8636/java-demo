package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   自动创建线程池
 * @author duan
 * @version 1.0
 * @date 2019/12/6 16:38
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() +"执行了...");
        });

        Thread.sleep(3000);
        executorService.submit(()->{
            System.out.println(Thread.currentThread().getName() +"执行了...");
        });

    }
}
