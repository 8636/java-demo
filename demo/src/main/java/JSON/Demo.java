package JSON;

import com.alibaba.fastjson.JSON;

public class Demo {
    public static void main(String[] args) {
        User user = new User("zhangsan","123");
        String s = JSON.toJSONString(user);
        System.out.println(s);
    }
}
