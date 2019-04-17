package xuanc.concert;

/**
 * ClassName    Spring4-DefaultEncoreable
 * Description  Encoreable　接口的实现类
 *
 * @author      xuanc
 * @date        19-4-17 下午3:49
 * @version     1.0
 */
public class DefaultEncoreable implements Encoreable {

    public void performEncore() {
        System.out.println("Add method for Performance by AOP!");
    }

}
