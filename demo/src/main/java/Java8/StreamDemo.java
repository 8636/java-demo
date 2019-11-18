package Java8;

import java.util.ArrayList;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/11 16:44
 */
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("林青霞");
        list.add("张曼玉");
        list.add("王祖贤");
        list.add("柳岩");
        list.add("张敏");
        list.add("张无忌");
        list.forEach(s -> System.out.println(s));

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);

    }
}
