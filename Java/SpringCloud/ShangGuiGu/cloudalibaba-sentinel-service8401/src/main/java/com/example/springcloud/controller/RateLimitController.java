package com.example.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.handler.CustomerBlockerHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/24 下午3:37
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK",
                new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException ex) {
        return new CommonResult(444, ex.getClass().getCanonicalName() + "\t 服务不可用");
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockerHandler.class,
            blockHandler = "handlerException")
    public CommonResult customBlockHandler() {
        return new CommonResult(200, "按客户自定义");
    }

}
