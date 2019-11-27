import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class MySingleton {
    private static final String pushStopCharge = "notification_stop_charge_result";
    private static final String pushChargeOrder = "notification_charge_order_info";
    private static ExecutorService threadPoolExecutor;

    static {
        threadPoolExecutor = Executors.newSingleThreadExecutor();
        log.info("线程池创建完毕");
    }


    //使用volatile关键字保其可见性
    volatile private static MySingleton instance = null;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        try {
            if (instance != null) {//懒汉式

            } else {
                //创建实例之前可能会有一些准备性的耗时工作
                Thread.sleep(300);
                synchronized (MySingleton.class) {
                    if (instance == null) {//二次检查
                        instance = new MySingleton();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * 监控任务状态  推送停止充电结果 和订单信息
     */
    public void start() {
        threadPoolExecutor.execute(() -> {
            log.info("start...");
            while (true) {
                try {
                    Thread.sleep(1000 * 10);
                    log.info(Thread.currentThread().getName());
                    log.info("do something...");
                } catch (Throwable throwable) {
                    log.error(throwable.getMessage());
                    throwable.printStackTrace();
                }
            }
        });
    }
}