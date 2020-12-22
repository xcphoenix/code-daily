package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/1 上午11:26
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById( Long id);

}
