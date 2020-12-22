package com.ssm.chapter11.aop.config;

import com.ssm.chapter11.aop.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName    Chapter11-AopConfig
 * Description  
 *
 * @author      xuanc
 * @date        19-5-24 下午10:09
 * @version     1.0
 */
@Configuration
// 启用自动代理
@EnableAspectJAutoProxy
@ComponentScan("com.ssm.chapter11.aop")
public class AopConfig {

    @Bean
    public RoleAspect getRoleAspect() {
        return new RoleAspect();
    }

}
