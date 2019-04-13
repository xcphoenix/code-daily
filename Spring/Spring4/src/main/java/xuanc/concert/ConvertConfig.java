package xuanc.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName    Spring4-ConvertConfig
 * Description  通过使用注解 @EnableAspectJAutoProxy 来启用自动配置代理
 *
 * @author      xuanc
 * @date        19-4-13 下午9:06
 * @version     1.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConvertConfig {

    /**
     * 声明 AspectJ 自动代理
     * @return bean
     */
    @Bean
    public Audience audience() {
        return new Audience();
    }

}
