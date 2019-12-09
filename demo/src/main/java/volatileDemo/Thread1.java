package volatileDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/8 12:10
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        while (Money.money == 100000){

        }
        System.out.println("Money 值已改变为" + Money.money);
    }
}
