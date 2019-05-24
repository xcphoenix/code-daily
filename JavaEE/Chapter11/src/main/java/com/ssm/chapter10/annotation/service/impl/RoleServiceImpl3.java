package com.ssm.chapter10.annotation.service.impl;

import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter11-RoleServiceImpl3
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午8:31
 * @version     1.0
 */
@Component("roleService3")
// @Primary
public class RoleServiceImpl3 implements RoleService {

    @Override
    public void printRoleInfo(Role role) {
        System.out.println("[Bean] roleService3");
        System.out.println("{id=" + role.getId());
        System.out.println(", roleName =" + role.getRoleName());
        System.out.println(", note =" + role.getNote() + "}");
    }
}
