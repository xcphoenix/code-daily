package xuanc;

import org.junit.*;
import static org.junit.Assert.assertTrue;

/**
 * ClassName    Junit4-AssertTest
 * Description  测试断言方法
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-25 下午9:06
 */
public class AssertTest {

    public static Boolean Prime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPrime() {
        int n = 7;
        assertTrue(AssertTest.Prime(n));
    }
}
