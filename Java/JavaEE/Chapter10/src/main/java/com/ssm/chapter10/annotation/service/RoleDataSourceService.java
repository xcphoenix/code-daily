package com.ssm.chapter10.annotation.service;

import com.ssm.chapter10.annotation.pojo.Role;

/**
 * ClassName    Chapter11-RoleDataSourceService
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午9:29
 * @version     1.0
 */
public interface RoleDataSourceService {
    public Role getRole(Long id);
}
