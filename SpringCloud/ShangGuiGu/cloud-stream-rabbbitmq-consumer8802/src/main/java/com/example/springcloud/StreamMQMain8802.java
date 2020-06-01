package com.example.springcloud;

import org.apache.http.cookie.SM;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author      xuanc
 * @date        2020/5/20 下午4:19
 * @version     1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8802.class, args);
    }

}
