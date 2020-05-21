package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author      xuanc
 * @date        2020/5/21 下午4:09
 * @version     1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryMain9001.class, args);
    }

}
