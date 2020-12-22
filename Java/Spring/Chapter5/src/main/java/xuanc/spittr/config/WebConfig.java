package xuanc.spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * ClassName    Chapter5-WebConfig
 * Description  @EnableWebMvc => 启用 Spring MVC
 *              --------------------------------
 *              最小但可用的 Spring MVC 配置
 *
 * @author      xuanc
 * @date        19-4-18 下午8:51
 * @version     1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan("xuanc.spittr")
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置 JSP 视图解析器（会查找 Jsp）
     * @return 视图解析器
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        // 设置前缀
        resolver.setPrefix("/views/");
        // 设置后缀
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 配置静态资源的处理
     * @param configurer ...
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 要求将对静态资源的请求转发到 Servlet 容器默认的 Servlet 上
        configurer.enable();
    }
}
