package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    private DiscoveryClient discoveryClient;

    private final PaymentService paymentService;

    public PaymentController(DiscoveryClient discoveryClient, PaymentService paymentService) {
        this.discoveryClient = discoveryClient;
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("insert res: " + result);

        if (result > 0) {
            return new CommonResult<>(200, "port: " + port + ", 插入数据库成功", result);
        } else {
            return new CommonResult<>(444, "port: " + port + ", 插入数据库失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("get res: " + (result == null ? "null" : result.toString()));

        if (result != null) {
            return new CommonResult<>(200, "port: " + port + ", 查询成功", result);
        } else {
            return new CommonResult<>(444, "port: " + port + ", 查询失败，记录不存在");
        }
    }

    /**
     * 获取服务信息
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String ele : services) {
            log.info("element; " + ele);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB() {
        return port;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "zipkin ~qwertyuio";
    }

}
