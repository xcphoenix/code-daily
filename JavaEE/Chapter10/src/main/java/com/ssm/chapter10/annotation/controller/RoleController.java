package com.ssm.chapter10.annotation.controller;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter11-RoleController
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午8:35
 * @version     1.0
 */
@Component
public class RoleController {

    @Autowired
    @Qualifier("roleService3")
    private RoleService roleService = null;

    public void printRole(Role role) {
        roleService.printRoleInfo(role);
    }
}
