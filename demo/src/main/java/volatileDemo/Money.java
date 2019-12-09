package volatileDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/8 12:10
 */
public class Money {
    public static volatile int money = 100000;
    public static Object lock = new Object();
}
