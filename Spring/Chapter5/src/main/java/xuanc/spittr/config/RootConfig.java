package xuanc.spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * ClassName    Chapter5-RootConfig
 * Description
 * FilterType
 *              ~ ANNOTATION 通过注解类型 列如 @Controller为Controller.class @Service 为 Service.class
 *              ~ ASSIGNABLE_TYPE, 一组具体类 例如PersonController.class
 *              ~ ASPECTJ, 一组表达式,使用Aspectj表达式命中类
 *              ~ REGEX 一组表达式,使用正则命中类
 *              ~ CUSTOM 自定义的TypeFilter.
 *              ------------------------------------------------------------------------------------
 *              - excludeFilters = Filter[] 根据规则排除组件
 *
 * @author      xuanc
 * @date        19-4-18 下午9:20
 * @version     1.0
 */
@Configuration
@ComponentScan(basePackages = {"xuanc.spittr"},
excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
})
public class RootConfig {

}
