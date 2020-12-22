package xuanc.chapter7;

/**
 * ClassName    Chapter7-IdentityHashCodeTest
 * Description  System.identityHashCode()
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午10:11
 */
public class IdentityHashCodeTest {

    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        // s1 s2 不是同一个对象
        System.out.println(System.identityHashCode(s1) == System.identityHashCode(s2));

        String s3 = "Java";
        String s4 = "Java";

        System.out.println(System.identityHashCode(s3) == System.identityHashCode(s4));
    }
}
