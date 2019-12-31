package array.demo;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author duan
 * @version 1.0
 * @date 2019/12/4 13:51
 */
public class TestNewDateApi {
    public static void main(String[] args) {
        Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;
        String format = String.format("无法找到%s服务", "hello");
        System.out.println(format);
    }
}
