package xuanc;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * ClassName    Chapter15-ReadTeacher
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午7:22
 * @version     1.0
 */ 
public class ReadTeacher {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectInputStream 输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/teacher.txt")
                )
        ) {
            // 依次读取 ObjectInputStream 输入流中的4个对象
            Teacher t1 = (Teacher)ois.readObject();
            Teacher t2 = (Teacher)ois.readObject();
            Person p = (Person) ois.readObject();
            Teacher t3 = (Teacher)ois.readObject();
            System.out.println("t1 的 student 引用和p是否相同：" + (t1.getStudent() == p));
            System.out.println("t2 的 student 引用和p是否相同：" + (t2.getStudent() == p));
            System.out.println("t2 和 t3 是否为同一个对象：" + (t2 == t3));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
