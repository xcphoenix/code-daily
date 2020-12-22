package xuanc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ClassName    Chapter15-WriteObject
 * Description  将 Person 写入磁盘文件
 *
 * @author      xuanc
 * @date        19-5-6 下午6:53
 * @version     1.0
 */ 
public class WriteObject {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectOutputStream 输出流
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("target/object.txt")
                )
        ) {
            Person per = new Person("孙悟空", 500);
            // 将 per 对象写入输入流
            oos.writeObject(per);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
