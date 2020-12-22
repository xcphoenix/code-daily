package com.ssm.chapter5.mapper;

import com.ssm.chapter5.pojo.EmployeeTask;

/**
 * ClassName    chapter5-EmployeeTaskMapper
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 上午11:31
 * @version     1.0
 */ 
public interface EmployeeTaskMapper {

    /**
     * ...
     * @param empId 雇员 id
     * @return EmployeeTaskMapper
     */
    EmployeeTask getEmployeeTaskByEmpId(Long empId);

}
