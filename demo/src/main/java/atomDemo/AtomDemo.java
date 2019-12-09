package atomDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 15:39
 */
public class AtomDemo {
    public static void main(String[] args) {
        MyAtomThread myAtomThread = new MyAtomThread();
        for (int i = 0; i < 100; i++) {
            new Thread(myAtomThread).start();
        }

    }
}
