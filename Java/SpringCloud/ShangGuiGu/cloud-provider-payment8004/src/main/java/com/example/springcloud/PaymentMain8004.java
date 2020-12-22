package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author      xuanc
 * @date        2020/5/1 上午10:25
 * @version     1.0
 */
@SpringBootApplication
// consul 或 zookeeper 使用这个作为服务发现的注解
@EnableDiscoveryClient
public class PaymentMain8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class);
    }

}
