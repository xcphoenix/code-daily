package xuanc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ClassName    Chapter15-TransientTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午8:08
 * @version     1.0
 */ 
public class TransientTest {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectOutputStream 输出流
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("target/transient.txt")
                );
                // 创建一个 ObjectInputStream 输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/transient.txt")
                )
        ) {
            Person1 per = new Person1("孙悟空", 500);
            // 系统将 per 对象转化为字节序列输出
            oos.writeObject(per);
            Person1 p = (Person1)ois.readObject();
            System.out.println(p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
