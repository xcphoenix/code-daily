package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author      xuanc
 * @date        2020/5/14 下午10:45
 * @version     1.0
 */
@RestController
@Slf4j
// 统一的 fallback
@DefaultProperties(defaultFallback = "paymentTimeoutFallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/order/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("--- result: " + result);
        return result;
    }

    // @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallbackMethod", commandProperties = {
    //         // 设置线程的超时时间为3秒
    //         @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    // })
    @HystrixCommand
    @GetMapping("/order/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("--- result: " + result);
        return result;
    }

    public String paymentInfoTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "Sorry, I'm consumer80, service busy, please wait some time try again";
    }

    // 默认fallback不能有参数，返回值要兼容
    public String paymentTimeoutFallbackMethod() {
        return "Sorry, I'm consumer80, service busy, please wait some time try again【from global】";
    }

}
