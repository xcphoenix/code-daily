package xuanc;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * ClassName    Junit4-TestFixture
 * Description  JUnit 中的 Fixture
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-25 下午8:41
 */
public class TestFixture {

    /**
     * 在当前测试类开始时运行
     */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass>>>>>>>>>>>>>>>");
    }

    /**
     * 在当前测试类开始时运行
     */
    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass>>>>>>>>>>>>>>>");
    }

    /**
     * 每个测试方法运行之前运行
     */
    @Before
    public void before() {
        System.out.println("---- before");
    }

    /**
     * 每个测试方法运行之后运行
     */
    @After
    public void after() {
        System.out.println("---- after");
    }

    /**
     * 测试方法
     */
    @Test
    public void testAdd1() {
        int result = new Count().add(5, 3);
        assertEquals(8, result);
        System.out.println("test Run testAdd1");
    }

    /**
     * 测试方法
     */
    @Test
    public void testAdd2() {
        int result = new Count().add(15, 13);
        assertEquals(28, result);
        System.out.println("test Run testAdd2");
    }
}
