package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.FemaleHealthForm;

/**
 *
 * ClassName    chapter5-FemaleHealthFormMapper
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 下午12:03
 * @version     1.0
 */ 
public interface FemaleHealthFormMapper {

    /**
     * 获得女性体检表
     * @param id id
     * @return FemaleHealthForm - POJO
     */
    FemaleHealthForm getFemaleHealthForm(Long id);

}
