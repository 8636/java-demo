package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/5 9:07
 */
public class ThreadTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

       /* MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.setPriority(11);
        String s = futureTask.get();
        System.out.println(s);*/

        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"窗口1");
        Thread thread2 = new Thread(ticket,"窗口2");
        Thread thread3 = new Thread(ticket,"窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
