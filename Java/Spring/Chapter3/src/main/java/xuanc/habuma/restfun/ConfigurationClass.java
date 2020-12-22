package xuanc.habuma.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName    Chapter3-ConfigurationClass
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午8:50
 */
@Configuration
public class ConfigurationClass {

    @Bean
    @Conditional(IsLinuxCondition.class)
    public String getLinux() {
        return new String("Linux");
    }

    @Bean
    @Conditional(IsWindowsCondition.class)
    public String getWindows() {
        return new String("Windows");
    }

}
