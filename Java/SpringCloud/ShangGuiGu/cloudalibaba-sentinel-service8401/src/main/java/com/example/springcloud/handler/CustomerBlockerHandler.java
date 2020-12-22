package com.example.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.springcloud.entities.CommonResult;

/**
 * @author      xuanc
 * @date        2020/5/24 下午5:06
 * @version     1.0
 */ 
public class CustomerBlockerHandler {

    /**
     * 必须为 <code>static</code>
     */
    public static CommonResult handlerException(BlockException ex) {
        return new CommonResult(4444, "按客户自定义, global");
    }



}
