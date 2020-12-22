package xuanc;

/**
 * ClassName    Chapter6-FinalLocalVariableTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:40
 */
public class FinalLocalVariableTest {
    public static void test(final int a) {
        // error
        // a = 5;
        System.out.println(a);
    }

    public static void main(String[] args) {
        final String str = "hello";
        // str = "Java";
        final double d;
        d = 5.6;
        final int b = 5;
        test(b);
        // d = 3.4;
    }
}
