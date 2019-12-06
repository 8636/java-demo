package thread;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/6 10:09
 */
public class Demo {
    public static void main(String[] args) {
        Desk desk = new Desk();
        Consumer consumer = new Consumer(desk);
        Producter producter = new Producter(desk);
        Consumer consumer1 = new Consumer(desk);
        Producter producter2 = new Producter(desk);
        consumer.setName("吃货一号");
        consumer1.setName("吃货二号");
        producter.setName("大厨");
        producter2.setName("帮厨");
        consumer.start();
        producter.start();
        consumer1.start();
        producter2.start();
    }
}
