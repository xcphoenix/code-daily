package xuanc;
/**
 * ClassName    Chapter5-PrimitiveTransferTest
 * Description  test
 * @author      xuanc
 * @date        19-3-16 下午5:02
 * @version     1.0
 */ 
public class PrimitiveTransferTest {
    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        swap(a, b);
        System.out.println("a = " + a + ", b = " + b);
    }
}
