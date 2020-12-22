package xuanc;

/**
 * ClassName    Chapter5-Overload
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-16 下午5:23
 */
public class Overload {
    static void test(String msg) {
        System.out.println("void test(String msg)");
    }

    static void test(String... msg) {
        System.out.println("=======================");
        for(String tmp : msg) {
            System.out.println("=> " + tmp);
        }
        System.out.println("=======================");
    }

    static void test(int a) {
        System.out.println("void test(int a)");
    }

    static void test(Integer a) {
        System.out.println("void test(Integer a)");
    }

    public static void main(String[] args) {
        test("test0");
        test("test1", "test2");
        test(new String[] {"test3"});
        test(new Integer(4));
    }
}
