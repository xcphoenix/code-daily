package com.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/25 下午6:45
 */
@Mapper
public interface AccountDao {

    void decrease(@Param("userId") Long userId,
                  @Param("money") BigDecimal money);

}
