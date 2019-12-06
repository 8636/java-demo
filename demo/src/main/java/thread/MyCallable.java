package thread;

import java.util.concurrent.Callable;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/5 9:05
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("hah"+ i);
        }
        return "en";
    }
}
