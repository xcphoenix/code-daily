package xuanc;

/**
 * ClassName    Chapter5-Varargs
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-16 下午5:15
 */
public class Varargs {
    // 定义了形参可变的方法
    private static void test(int a, String... books) {
        // books 当做数组来处理
        for (String tmp : books) {
            System.out.println(tmp);
        }
        System.out.println(a);
    }
    public static void main(String[] args) {
        test(5, "test", "two", "again", "some", "....");
    }
}
