package xuanc;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class CountTest {

    /**
     * 验证超时
     */
    @Test(timeout = 100)
    public void testAdd() throws InterruptedException {
        // 休眠 100 毫秒
        Thread.sleep(101);
        new Count().add(1, 2);
    }

    /**
     * 验证抛出异常
     */
    @Test(expected = ArithmeticException.class)
    public void testDivision() {
        new Count().division(8, 0);
    }

    /**
     * 跳过该条测试用例
     */
    @Ignore
    @Test
    public void testAdd2() {
        Count count = new Count();
        int result = count.add(2, 2);
        assertEquals(result, 4);
    }
}
