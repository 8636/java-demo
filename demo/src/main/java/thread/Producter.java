package thread;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/6 10:05
 */
public class Producter extends Thread {
    private Desk desk;

    public Producter(Desk desk) {
        this.desk = desk;
    }

    @Override
    public void run() {
        while (true){
            synchronized (desk.getLock()){
                if (desk.getCount() == 0){
                    break;
                }else {
                    if (!desk.isFalg()){
                        System.out.println(Thread.currentThread().getName() + "制作了一个面包并放入盘中");
                        //桌上没食物 可以生产
                        desk.setFalg(true);
//                        desk.getLock().notifyAll();
                        desk.getLock().notify();
                    }else {
                        try {
                            desk.getLock().wait();
                            System.out.println(Thread.currentThread().getName() + "休眠");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
