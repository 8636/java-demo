package array.demo;

import java.util.TreeSet;

/**
 * @author duan
 * @version 1.0
 * @date 2019/11/28 14:35
 */
public class TestTreeSet {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Student> ts = new TreeSet<Student>();
        Student student = new Student();
        student.setName("00:00");
        student.setAge(10);
        Student student1 = new Student();
        student.setName("08:00");
        student.setAge(10);
        Student student2 = new Student();
        student.setName("10:00");
        student.setAge(10);
        ts.add(student);
        ts.add(student1);
        ts.add(student2);
        for (Student t : ts) {
            System.out.println(t);
        }
    }
}
