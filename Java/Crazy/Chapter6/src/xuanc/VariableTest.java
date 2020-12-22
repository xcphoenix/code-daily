package xuanc;

/**
 * ClassName    Chapter6-VariableTest
 * Description  final 修饰成员变量的各种具体情况
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:28
 */
public class VariableTest {
    // 声明时指定
    final int a = 6;
    // 在构造器或初始化块中指定
    final String str;
    final int c;
    final static double d;

    {
        str = "Hello";
        // a = 9;
    }

    static {
        d = 5.6;
    }

    public VariableTest() {
        c = 5;
    }

    public static void main(String[] args) {

    }
}
