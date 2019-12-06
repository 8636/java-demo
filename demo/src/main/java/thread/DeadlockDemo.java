package thread;

/**
 * 死锁demo  锁的嵌套使用
 *
 * @author duan
 * @version 1.0
 * @date 2019/12/6 9:24
 */
public class DeadlockDemo {
    private static Object objA = new Object();
    private static Object objB = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                synchronized (objA) {
                    synchronized (objB){
                        System.out.println(Thread.currentThread().getName() + "执行了...");
                    }
                }
            }

        }).start();

        new Thread(()->{
            while (true){
                synchronized (objB){
                    synchronized (objA){
                        System.out.println(Thread.currentThread().getName() + "执行了...");
                    }
                }
            }
        }).start();

    }
}
