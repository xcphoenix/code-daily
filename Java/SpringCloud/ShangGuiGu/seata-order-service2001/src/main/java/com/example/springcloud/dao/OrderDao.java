package com.example.springcloud.dao;

import com.example.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/25 下午6:45
 */
@Mapper
public interface OrderDao {

    void create(@Param("order") Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
