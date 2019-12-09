package atomDemo;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/9 15:50
 */
public class AtomDemo1 {
    public static void main(String[] args) {
        MyAtomThreadDemo1 myAtomThreadDemo1 = new MyAtomThreadDemo1();
        for (int i = 0; i < 100; i++) {
            new Thread(myAtomThreadDemo1).start();
        }
    }
}
