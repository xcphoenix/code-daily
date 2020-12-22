package xuanc.dealWithAmbiguity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName    Chapter3-AmbiguityTest
 * Description  
 *
 * @author      xuanc
 * @date        19-4-12 下午8:15
 * @version     1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DealConfig.class)
public class AmbiguityTest {

    private Dessert dessert;

    /**
     * 3.  @Qualifier 注解，使用限定符，参数为 bean 的 ID，但与bean的名称（默认为类名首字母小写）紧耦合
     * @param dessert 参数
     */
    // @Qualifier("cookies")
    @Autowired
    /**
     * 5. ..
     */
    @Creamy
    @Cold
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    /**
     * 1. 如果不处理自动装配的歧义，Spring 无法做出选择，会抛出异常：
     *    org.springframework.beans.factory.NoUniqueBeanDefinitionException:
     *    No qualifying bean of type 'xuanc.dealWithAmbiguity.Dessert' available:
     *    expected single matching bean but found 3: cake,cookies,iceCream
     * --------------------------------------------------------------------------
     * 2. 使用 @Primary 注解，标志首选 bean，但若是标记了多个注解无法正常工作
     * 3. 使用限定符 @Qualifier 注解
     * 4. 使用自定义注解 在创建组件或者bean时，使用 @Qualifier("name...") 来创建自定义的限定符
     *    缺点：该注解不能重复使用，不能将自动装配可选的 bean 限制到一个 bean
     * 5. 可以通过自定义注解来表达 bean 所希望的特性
     */
    @Test
    public void testDessert() {
        System.out.println(this.dessert);
    }
}
