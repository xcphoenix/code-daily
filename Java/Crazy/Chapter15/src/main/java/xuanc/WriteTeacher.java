package xuanc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ClassName    Chapter15-WriteTeacher
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午7:17
 * @version     1.0
 */ 
public class WriteTeacher {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectOutputStream 输出流
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("target/teacher.txt")
                )
        ) {
            Person per = new Person("孙悟空", 500);
            Teacher t1 = new Teacher("唐僧", per);
            Teacher t2 = new Teacher("菩提老祖", per);
            // 依次将 4 个对象写入输出流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
