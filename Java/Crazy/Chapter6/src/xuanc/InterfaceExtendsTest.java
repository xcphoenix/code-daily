package xuanc;

interface InterfaceA {
    int PROP_A = 5;
    void testA();
}
interface InterfaceB {
    int PROP_B = 6;
    void testB();
}
interface InterfaceC extends InterfaceA, InterfaceB {
    int PROP_C = 7;
    void testC();
}

/**
 * ClassName    Chapter6-InterfaceExtendsTest
 * Description  接口的多继承
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午6:40
 */
public class InterfaceExtendsTest {
    public static void main(String[] args) {
        System.out.println(InterfaceC.PROP_A);
        System.out.println(InterfaceC.PROP_B);
        System.out.println(InterfaceC.PROP_C);
    }
}
