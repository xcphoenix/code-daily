package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * ClassName    Chapter2-CDPlayerConfig
 * Description  使用 JavaConfig 装配 bean
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-24 下午3:01
 */
@Configuration
@ComponentScan
/**
 * 将 CDConfig.class 整合
 */
// @Import(CDConfig.class)
/**
 * 整合 xml 配置
 */
@ImportResource("classpath:java_xml.xml")
public class CDPlayerConfig {

    /**
     * public CDPlayer(CompactDisc cd)
     * ------------------------------
     * CompactDisc 并非通过调用 sgtPeppers() 方法得到的
     * 由于 sgtPeppers() 上添加了 @Bean 注解，Spring 会拦截所有对他的调用，确保直接返回该方法所创建的 bean
     * [默认情况下，Spring 中的 bean 都是单例的]
     */
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    // /**
    //  * 另一种方式
    //  * -----------------------------------------------------
    //  * 当调用 cdPlayer(CompactDisc compactDisc) 来创建 CDPlayer bean 时，会自动装配一个 CompactDisc bean
    //  * 优点：
    //  *     这种方式可以将创建多个 bean 的声明放在同一个配置类甚至 JavaConfig 类中，
    //  *     可以通过组件扫描自动发现或 XML 来配置
    //  */
    // @Bean
    // public CDPlayer cdPlayer(CompactDisc compactDisc) {
    //     return new CDPlayer(compactDisc);
    // }
}
