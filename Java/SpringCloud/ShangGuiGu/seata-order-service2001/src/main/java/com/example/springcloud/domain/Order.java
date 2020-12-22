package com.example.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author      xuanc
 * @date        2020/5/25 下午6:43
 * @version     1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Long count;

    private BigDecimal money;

    private Integer status;

}
