package com.ssm.chapter14.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * ClassName    Chapter14-MyWebAppInitializer
 * Description  通过注解来配置 Spring MVC
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-15 下午12:31
 */
public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring IoC 容器配置，用来装载各种 Spring Bean
     *
     * @return Spring 的 Java 配置数组
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{};
    }

    /**
     * DispatcherServlet 的 URI 映射关系配置，产生 Web 请求的上下文
     *
     * @return Spring 的 Java 配置数组
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    /**
     * DispatcherServlet 拦截内容
     *
     * @return ...
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.do"};
    }
}
