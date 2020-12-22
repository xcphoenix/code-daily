package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.WorkCard;

/**
 * @author xuac
 * Descritption Mapper-Interface
 */
public interface WorkCardMapper {

    /**
     * 获取 WorkCard
     * @param empId 雇员id
     * @return WorkCard - POJO
     */
    WorkCard getWorkCardByEmpId(Long empId);
}
