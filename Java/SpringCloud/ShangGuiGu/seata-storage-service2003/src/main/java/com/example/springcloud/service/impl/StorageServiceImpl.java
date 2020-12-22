package com.example.springcloud.service.impl;

import com.example.springcloud.dao.StorageDao;
import com.example.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author      xuanc
 * @date        2020/5/26 上午11:26
 * @version     1.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("扣减库存结束");
    }

}
