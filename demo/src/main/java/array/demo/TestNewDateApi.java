package array.demo;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/4 13:51
 */
public class TestNewDateApi {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        ReentrantLock lock = new ReentrantLock();
    }
}
