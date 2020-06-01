package com.ssm.chapter14.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * ClassName    Chapter14-WebConfig
 * Description  
 *
 * @author      xuanc
 * @date        19-5-15 下午12:38
 * @version     1.0
 */
@Configuration
@ComponentScan("com.*")
@EnableWebMvc
public class WebConfig {

    /**
     * 创建视图解析器
     * @return 视图解析器
     */
    @Bean(name="viewResolver")
    public ViewResolver initViewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
