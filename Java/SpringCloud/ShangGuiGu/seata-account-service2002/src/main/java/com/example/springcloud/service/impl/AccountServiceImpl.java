package com.example.springcloud.service.impl;

import com.example.springcloud.dao.AccountDao;
import com.example.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author      xuanc
 * @date        2020/5/26 上午11:26
 * @version     1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("扣减账户余额开始");
        accountDao.decrease(userId, money);
        log.info("扣减账户余额结束");
    }

}
