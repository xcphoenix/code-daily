package xuanc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * ClassName    Chapter15-ReplaceTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-7 下午3:26
 * @version     1.0
 */ 
public class ReplaceTest {

    public static void main(String[] args) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("target/replace.txt")
                );
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/replace.txt")
                )
        ) {
            Person3 per = new Person3("孙悟空", 500);
            oos.writeObject(per);
            ArrayList list = (ArrayList)ois.readObject();
            System.out.println(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
