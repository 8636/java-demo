package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/5 17:31
 */
public class Ticket implements Runnable {
    private int ticketCount = 20;
    private final String s = "lock";
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            // 锁对象可以是任意 对象，但是对于所有共享资源的线程时一样的。
            synchronized (this) {
                if (ticketCount <= 0) {
                    break;
                } else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "在卖票" + "还剩" + ticketCount + "张票");

            }
        }
    }
}
