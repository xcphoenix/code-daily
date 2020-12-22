package com.example.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/26 上午10:05
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);

}
