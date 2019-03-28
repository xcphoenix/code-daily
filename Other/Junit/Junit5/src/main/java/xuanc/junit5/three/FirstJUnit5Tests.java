package xuanc.junit5.three;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * ClassName    Junit5-FirstJUnit5Tests
 * Description  [Junit5] 测试用例
 * @author      xuanc
 * @date        19-3-27 下午3:48
 * @version     1.0
 */ 
public class FirstJUnit5Tests {

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}
