package com.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/15 上午10:46
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfoOk(Integer id) {
        return "--- PaymentFallbackService OK, :(";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "--- PaymentFallbackService Timeout, :(";
    }

}
