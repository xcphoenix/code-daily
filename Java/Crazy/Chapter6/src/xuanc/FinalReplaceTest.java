package xuanc;

/**
 * ClassName    Chapter6-FinalReplaceTest
 * Description  可执行 “宏替换” 的 final 变量
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:59
 */
public class FinalReplaceTest {
    public static void main(String[] args) {
        // 下面定义了 4 个 final 宏变量
        final int a = 5 + 2;
        final double b = 1.2 / 3;
        final String str = "疯狂" + "Java";
        final String book = "疯狂 Java 讲义：" + 99.0;
        // 下面的 book2 变量由于调用了方法，无法在编译时被确定下来
        final String book2 = "疯狂 Java 讲义： 99.0" + String.valueOf(99.0);
        System.out.println(book == "疯狂 Java 讲义：99.0");
        System.out.println(book2 == "疯狂 Java 讲义：99.0");
    }
}
