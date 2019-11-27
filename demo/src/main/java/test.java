/**
 * @author duan
 * @version 1.0
 * @date 2019/11/21 9:13
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            MySingleton.getInstance().start();
        }
    }
}
