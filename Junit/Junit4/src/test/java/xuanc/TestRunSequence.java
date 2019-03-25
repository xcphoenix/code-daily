package xuanc;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertEquals;

/**
 * ClassName    Junit4-TestRunSequence
 * Description  用例测试顺序
 * 　　　　　　　　按[字母顺序]
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-25 下午8:58
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequence {

    @Test
    public void TestCase1() {
        assertEquals(2 + 2, 4);
        System.out.println("Run <TestCase1> ...");
    }

    @Test
    public void TestCase2() {
        assertEquals(2 + 2, 4);
        System.out.println("Run <TestCase2> ...");
    }

    @Test
    public void TestAa() {
        assertEquals("Hello", "hi");
    }
}
