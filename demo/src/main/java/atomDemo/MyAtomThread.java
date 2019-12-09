package atomDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 15:38
 */
public class MyAtomThread implements Runnable {
    //1、从共享数据中读取数据到本线程栈中
    //2、修改本线程栈中变量副本的值
    //3、把本线程栈中变量副本赋值到共享数据中
    private int count = 0;
    private Object lock = new Object();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock){
                count++;
                System.out.println("已经送了" +count+ "个冰淇淋");
            }
        }
    }
}
