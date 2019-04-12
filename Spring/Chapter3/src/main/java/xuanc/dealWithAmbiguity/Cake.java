package xuanc.dealWithAmbiguity;

import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter3-Cake
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-12 下午8:11
 */
@Component
public class Cake implements Dessert {
    @Override
    public String toString() {
        return "Cake";
    }
}
