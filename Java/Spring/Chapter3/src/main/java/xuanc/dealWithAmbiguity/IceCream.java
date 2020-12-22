package xuanc.dealWithAmbiguity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter3-IceCream
 * Description  
 *
 * @author      xuanc
 * @date        19-4-12 下午8:13
 * @version     1.0
 */
@Component
/**
 * 2. 标示首选的 bean
 */
// @Primary
/**
 * 5. 使用自定义注解
 */
@Cold
@Creamy
public class IceCream implements Dessert {
    @Override
    public String toString() {
        return "IceCream";
    }
}
