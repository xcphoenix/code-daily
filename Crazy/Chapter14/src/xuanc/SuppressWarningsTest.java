package xuanc;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName    Chapter14-SuppressWarningsTest
 * Description  抑制编译器警告： @SuppressWarnings
 * --------------------------------------------
 *              使用 @SuppressWarnings 要在括号里使用 name=value 的形式为该注解的成员变量设置值
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午10:15
 */
@SuppressWarnings(value = "unchecked")
public class SuppressWarningsTest {

    public static void main(String[] args) {
        List<String> myList = new ArrayList();
    }

}
