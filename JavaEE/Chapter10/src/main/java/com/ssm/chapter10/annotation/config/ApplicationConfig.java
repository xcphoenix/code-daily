package com.ssm.chapter10.annotation.config;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * ClassName    Chapter11-ApplicationConfig
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-19 下午8:57
 */
@ComponentScan(basePackages = "com.ssm.chapter10.annotation")
@ImportResource({"classpath:spring-dataSource.xml"})
@PropertySource(value = {"classpath:database-config.properties"}, ignoreResourceNotFound = true)
public class ApplicationConfig {

    /**
     * 加载 properties 属性文件后，Spring 没有解析属性占位符的能力，
     * 需要使用一个属性文件解析类来处理
     * @return 创建的单例 属性文件解析类
     */
    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
