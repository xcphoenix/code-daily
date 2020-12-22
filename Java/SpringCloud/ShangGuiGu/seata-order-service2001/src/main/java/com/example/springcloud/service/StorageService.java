package com.example.springcloud.service;

import com.example.springcloud.domain.CommonResult;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author      xuanc
 * @date        2020/5/26 上午10:05
 * @version     1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("count") Long count);

}
