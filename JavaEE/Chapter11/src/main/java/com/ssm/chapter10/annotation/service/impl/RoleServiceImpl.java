package com.ssm.chapter10.annotation.service.impl;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter11-RoleServiceImpl
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午8:53
 * @version     1.0
 */
@Component
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRoleInfo(Role role) {
        System.out.println("id = " + role.getId());
        System.out.println("roleName = " + role.getRoleName());
        System.out.println("note = " + role.getNote());
    }
}
