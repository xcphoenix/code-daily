package com.example.springcloud.service.impl;

import com.example.springcloud.dao.OrderDao;
import com.example.springcloud.domain.Order;
import com.example.springcloud.service.AccountService;
import com.example.springcloud.service.OrderService;
import com.example.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author      xuanc
 * @date        2020/5/26 上午10:03
 * @version     1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    @GlobalTransactional
    public void create(Order order) {
        log.info("开始新建订单");
        orderDao.create(order);

        log.info("订单微服务开始调用库存，做扣减操作");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());

        log.info("更新订单状态");
        orderDao.update(order.getUserId(), 0);

        log.info("下单结束");
    }

}
