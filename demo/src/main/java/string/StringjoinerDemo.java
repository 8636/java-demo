package string;

import java.util.StringJoiner;

/**
 * Created by duan on 2019/12/16 16:53
 */
public class StringjoinerDemo {
    public static void main(String[] args) {

        User user = new User();
        user.setUsername("duan");
        user.setPassword("123");
        System.out.println(user);

        StringJoiner stringJoiner = new StringJoiner("---");
        stringJoiner.add("hello");
        stringJoiner.add("duan");
        System.out.println(stringJoiner.toString());
    }
}
