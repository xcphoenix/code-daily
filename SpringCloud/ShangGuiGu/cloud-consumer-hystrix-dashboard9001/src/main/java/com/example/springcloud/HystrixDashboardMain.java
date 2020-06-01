package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author      xuanc
 * @date        2020/5/15 下午4:58
 * @version     1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain.class, args);
    }

}
