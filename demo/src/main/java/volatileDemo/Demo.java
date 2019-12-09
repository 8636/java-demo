package volatileDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/8 12:12
 */
public class Demo {
    public static void main(String[] args) {
        Thread1 thread11 = new Thread1();
        Thread2 thread22 = new Thread2();
        Thread thread1 = new Thread(thread11);
        Thread thread2 = new Thread(thread22);
        
        thread1.start();
        thread2.start();
    }
}
