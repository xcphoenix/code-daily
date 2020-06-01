package com.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/5/25 下午6:45
 */
@Mapper
public interface StorageDao {

    void decrease(@Param("productId") Long productId,
                  @Param("count") Integer count);

}
