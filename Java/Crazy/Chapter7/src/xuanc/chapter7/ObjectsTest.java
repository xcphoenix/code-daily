package xuanc.chapter7;

import java.util.Objects;

/**
 * ClassName    Chapter7-ObjectsTest
 * Description  Objects 工具类的使用
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-30 下午3:47
 */
public class ObjectsTest {

    /**
     * 定义一个 obj 变量，它的默认值是 null
     */
    static ObjectsTest obj;

    public static void main(String[] args) {
        // 输出一个 null 对象的 hashCode 值，输出 0
        System.out.println(Objects.hashCode(obj));
        // 输出一个 null 对象的 toString，输出 null
        System.out.println(Objects.toString(obj));
        // 要求 obj 不能为 null，如果 obj 为 null 则引发异常
        System.out.println(Objects.requireNonNull(obj, "obj 参数不能是 null! "));
    }
}
