package com.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/23 上午10:23
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
        log.info(Thread.currentThread().getName() + '\t' + "testA");
        return "------ testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "------ testB";
    }

    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试");
        return "------ testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("异常比例");
        int age = 10 / 0;
        return "------ testE";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "/testHotkey", blockHandler = "deal_testHotkey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10 / 0;
        return "------ hotkey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException ex) {
        return "------ deal_testHotkey, :(";
    }

}
