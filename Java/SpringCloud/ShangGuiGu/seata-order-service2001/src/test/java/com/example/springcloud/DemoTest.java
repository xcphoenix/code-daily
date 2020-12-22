package com.example.springcloud;

import com.example.springcloud.dao.OrderDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author      xuanc
 * @date        2020/5/31 上午9:51
 * @version     1.0
 */
@SpringBootTest
public class DemoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    void test(){
        orderDao.update(1L,0);
    }

}
