package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.Employee;

/**
 * ClassName    chapter5-EmployeeMapper
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 下午2:11
 * @version     1.0
 */ 
public interface EmployeeMapper {

    /**
     * 雇员的映射关系
     * @param id id
     * @return ..
     */
    Employee getEmployee(Long id);
}
