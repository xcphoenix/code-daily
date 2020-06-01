package xuanc.habuma.restfun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName    Chapter3-OsTest
 * Description  操作系统测试
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午8:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConfigurationClass.class)
public class OsTest {

    @Autowired
    private String osName;

    @Test
    public void outputMsg() {
        System.out.println("SystemOS: " + osName);
    }

}
