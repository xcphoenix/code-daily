package xuanc;

/**
 * ClassName    Chapter6-UnsignedTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-21 下午9:00
 */
public class UnsignedTest {

    public static void main(String[] args) {
        System.out.println(Integer.toUnsignedString(-123, 2));
        System.out.println((-123 >> 1) + ", \n " + Integer.toUnsignedString((-123 >> 1), 2));
        System.out.println((-123 >>> 1) + ", \n  " + Integer.toUnsignedString((-123 >>> 1), 2));
        System.out.println("--------------------------------------------------------");
        byte b = -3;
    }
}
