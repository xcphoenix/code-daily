package xuanc;

import java.io.FileInputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * ClassName    Chapter15-FilterTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-6 下午7:43
 * @version     1.0
 */ 
public class FilterTest {

    public static void main(String[] args) {
        try (
                // 创建一个 ObjectInputStream 输入流
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("target/object.txt")
                )
        ) {
            ois.setObjectInputFilter((info) -> {
                System.out.println("===== 数据过滤 =====");
                ObjectInputFilter serialFilter =
                        ObjectInputFilter.Config.getSerialFilter();
                if (serialFilter != null) {
                    // 首先使用 ObjectInputFilter 执行默认的检查
                    ObjectInputFilter.Status status =
                            serialFilter.checkInput(info);
                    // 如果默认的检查结果不是　Status.UNDECIDED1
                    if (status != ObjectInputFilter.Status.UNDECIDED) {
                        // 直接返回检查结果
                        return status;
                    }
                }
                // 如果要恢复的对象不是１个
                if (info.references() != 1) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                if (info.serialClass() != null && info.serialClass() != Person.class) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                return ObjectInputFilter.Status.UNDECIDED;
            });

            // 从输入流中读取一个 Java 对象，并将其强制类型转换为 Person 类
            Person p = (Person)ois.readObject();
            System.out.println("名字为：" + p.getName() + "\n年龄为：" + p.getAge());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
