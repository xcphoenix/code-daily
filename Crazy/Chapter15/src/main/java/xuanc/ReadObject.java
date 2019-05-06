package xuanc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * ClassName    Chapter15-ReadObject
 * Description  反序列化
 *
 * @author      xuanc
 * @date        19-5-6 下午7:01
 * @version     1.0
 */ 
public class ReadObject {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectInputStream 输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/object.txt")
                )
        ) {
            // 从输入流中读取一个 Java 对象，强转为 Person 类
            Person p = (Person)ois.readObject();
            System.out.println("" +
                    "名字为：" + p.getName() + "\n年龄为：" + p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

/*
 * 当序列化类有多个父类时，这些父类要么有无参数的构造器、要么也是可序列化的
 * 否则反序列化时将抛出 InvalidClassException 异常。
 * 如果父类是不可序列化的，只是带无参数的构造器，则该父类中定义的成员变量值不会序列化到二进制流中
 */