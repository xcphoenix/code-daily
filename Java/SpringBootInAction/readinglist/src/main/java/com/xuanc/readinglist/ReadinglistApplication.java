package com.xuanc.readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 　　　xuanc
 * Description  应用程序的启动引导类，也是主要的 Spring 配置类
 * Note
 *     　　　　　 注解 @SpringBootApplication 开启组件扫描和自动配置
 *              1. @Configuration[Spring] 表明该类使用 Spring 基于 Java 的配置
 *              2. Spring的 @ComponentScan :启用组件扫描,这样你写的Web控制器类和其他组件才能被
 *                 自动发现并注册为Spring应用程序上下文里的Bean。
 *              3. Spring Boot 的 @EnableAutoConfiguration, 开启了Spring Boot自动配置的魔力
 */
@SpringBootApplication
public class ReadinglistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadinglistApplication.class, args);
    }

}
