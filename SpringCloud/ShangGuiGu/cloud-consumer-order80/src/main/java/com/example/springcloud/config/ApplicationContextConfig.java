package com.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author      xuanc
 * @date        2020/5/1 下午4:17
 * @version     1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 负载均衡
    // @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
