package atomDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 15:48
 */
public class MyAtomThreadDemo1 implements Runnable {
    private AtomicInteger ac = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            ac.incrementAndGet();
            System.out.println("已经送了" +ac+ "个冰淇淋");
        }
    }
}
