package xuanc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ClassName    Junit4-JunitDemo
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-25 下午8:07
 */
public class JunitDemo {

    @Test
    public void myFirstTest() {
        assertEquals(2+2, 4);
    }
}
