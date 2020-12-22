package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author      xuanc
 * @date        2020/5/21 下午10:41
 * @version     1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3377.class, args);
    }

}
