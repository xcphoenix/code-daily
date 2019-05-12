package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.MaleHealthForm;

/**
 * @author xuanc
 */
public interface MaleHealthFormMapper {

    /**
     * 获取男性体检表
     * @param id id
     * @return MaleHealthForm - POJO
     */
    MaleHealthForm getMaleHealthForm(Long id);

}
