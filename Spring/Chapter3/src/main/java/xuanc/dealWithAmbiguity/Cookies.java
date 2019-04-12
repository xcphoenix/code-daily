package xuanc.dealWithAmbiguity;

import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter3-Cookies
 * Description  
 *
 * @author      xuanc
 * @date        19-4-12 下午8:13
 * @version     1.0
 */
@Component
@Creamy
public class Cookies implements Dessert {
    @Override
    public String toString() {
        return "Cookies";
    }
}
