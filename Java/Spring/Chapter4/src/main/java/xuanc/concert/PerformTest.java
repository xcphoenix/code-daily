package xuanc.concert;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * ClassName    Spring4-PerformTest
 * Description  
 *
 * @author      xuanc
 * @date        19-4-17 下午4:06
 * @version     1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConvertConfig.class)
public class PerformTest {

    @Autowired
    public Performance performance;

    @Test
    public void testArrouund() throws Throwable {
        performance.perform();
    }

    @Test
    public void testAddNewMethod() {
        ((Encoreable)performance).performEncore();
    }
}
