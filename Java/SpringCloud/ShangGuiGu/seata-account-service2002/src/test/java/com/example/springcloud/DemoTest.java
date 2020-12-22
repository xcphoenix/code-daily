package com.example.springcloud;

import com.example.springcloud.dao.AccountDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;

/**
 * @author      xuanc
 * @date        2020/5/31 上午9:51
 * @version     1.0
 */
@SpringBootTest
public class DemoTest {

    @Autowired
    private AccountDao accountDao;

    @Test
    void test(){
        accountDao.decrease(1L, new BigDecimal(100));
    }

}
