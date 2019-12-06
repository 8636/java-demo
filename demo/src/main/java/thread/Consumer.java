package thread;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/6 9:20
 */
public class Consumer extends Thread {
    private Desk desk;
    public Consumer(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        while (true){
            synchronized (desk.getLock()){
               if (desk.getCount() == 0){
                   break;
               }else {
                   if (desk.isFalg()){
                       // 桌上有食物
                       System.out.println(Thread.currentThread().getName() +"从盘中拿了一个面包");
                       desk.setFalg(false);
                       desk.getLock().notifyAll();
                       desk.setCount(desk.getCount() - 1);
                   }else {
                       try {
                           desk.getLock().wait();
                           System.out.println(Thread.currentThread().getName() +"等待");
                       } catch (InterruptedException e) {
                       }
                   }
               }
            }
        }
    }
}
