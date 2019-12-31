package map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by duan on 2019/12/16 15:43
 */
public class HashMapDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Map<String, String> map = new HashMap<String,String>();
        map.put("duan","duan");

        Class<? extends Map> mapClassClass = map.getClass();
        Method capacity = mapClassClass.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity:" + capacity.invoke(map));

        Method size = mapClassClass.getDeclaredMethod("size");
        size.setAccessible(true);
        System.out.println("size:" + size.invoke(map));


    }
}
