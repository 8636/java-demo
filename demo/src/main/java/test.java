import java.io.File;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/21 9:13
 */
public class test {
    public static void main(String[] args) throws ParseException {
        String pathPrefix = "src/main/resources/static";
        String relativePath = pathPrefix + "/" + "2" +"/" + "3";
        //存放上传文件的文件夹
        File file = new File(relativePath);
        if (!file.isDirectory()) {
            //递归生成文件夹
            file.mkdirs();
        }
    }

      /*  HashSet<Object> objects1 = new HashSet<>();
        objects1.add("1");
        Set<String> set = new TreeSet<String>();
        set.add("08:00");
        set.add("00:00");
        set.add("24:00");
        set.add("18:00");
        set.add("12:00");
        set.add("20:00");
        System.out.println(set);

        Object[] objects = set.toArray();
        String s = "12:00-18:00,22:00-24:00";
        for (int i = 0; i < set.size(); i++) {
            if (i+1 ==set.size()){
                return;
            }
            String s1 = (String) objects[i] + "-"+ objects[i+1];
            if (s.contains(s1)){
                System.out.println("-----" + s1);
            }
            System.out.println(s1);
        }
    }*/
}
