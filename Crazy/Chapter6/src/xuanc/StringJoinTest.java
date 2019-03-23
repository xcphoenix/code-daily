package xuanc;

/**
 * ClassName    Chapter6-StringJoinTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午3:14
 */
public class StringJoinTest {
    public static void main(String[] args) {
        String s1 = "疯狂Java";
        String s2 = "疯狂" + "Java";
        System.out.println(s1 == s2);
        final String str1 = "疯狂";
        final String str2 = "Java";
        String str3 = str1 + str2;
        // 宏替换...
        System.out.println(s1 == str3);
    }
}
