package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/1 上午11:28
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    public String paymentZk() {
        return "Spring Clod with zookeeper: " + port + "\t" + UUID.randomUUID().toString();
    }

}
