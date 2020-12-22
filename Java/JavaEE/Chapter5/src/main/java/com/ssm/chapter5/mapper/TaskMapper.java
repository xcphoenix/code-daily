package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.Task;

/**
 * ClassName    chapter5-TaskMapper
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 上午11:21
 * @version     1.0
 */ 
public interface TaskMapper {

    /**
     * 获取id对应的task
     * @param id id
     * @return Task POJO
     */
    Task getTask(Long id);

}
