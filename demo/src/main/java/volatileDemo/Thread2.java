package volatileDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/8 12:10
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Money.money = 90000;
    }
}
