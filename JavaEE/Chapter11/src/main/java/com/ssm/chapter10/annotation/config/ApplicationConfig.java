package com.ssm.chapter10.annotation.config;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * ClassName    Chapter11-ApplicationConfig
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午8:57
 * @version     1.0
 */
@ComponentScan(basePackages = "com.ssm.chapter10")
// @ImportResource({"classpath:spring-dataSource.xml"})
public class ApplicationConfig {

}
