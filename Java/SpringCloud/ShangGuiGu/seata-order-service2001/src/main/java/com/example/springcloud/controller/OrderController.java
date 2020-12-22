package com.example.springcloud.controller;

import com.example.springcloud.domain.CommonResult;
import com.example.springcloud.domain.Order;
import com.example.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author      xuanc
 * @date        2020/5/26 上午10:31
 * @version     1.0
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

}
