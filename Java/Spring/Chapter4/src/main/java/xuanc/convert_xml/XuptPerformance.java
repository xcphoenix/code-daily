package xuanc.convert_xml;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * ClassName    Spring4-XuptPerformance
 * Description  编写一个 Performance 实现类
 *
 * @author      xuanc
 * @date        19-4-17 下午3:58
 * @version     1.0
 */
@Component
public class XuptPerformance implements Performance {

    public void perform() throws Throwable {
        int num = 2;
        int randomNUmber = new Random().nextInt(100);
        if (randomNUmber % num == 0) {
            System.out.println("This is a performance, you will like!");
        } else {
            throw new Throwable("Sorry... We messed up.");
        }
    }

}
