package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author      xuanc
 * @date        2020/5/23 上午10:23
 * @version     1.0
 */
@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        // try {
        //     TimeUnit.SECONDS.sleep(1);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        log.info(Thread.currentThread().getName() + "\t" + "testA");
        return "------ testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------ testB";
    }

}
