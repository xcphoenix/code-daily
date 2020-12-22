package com.example.springcloud.service;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/26 上午10:05
 */
public interface StorageService {

    void decrease(Long productId, Integer count);

}
