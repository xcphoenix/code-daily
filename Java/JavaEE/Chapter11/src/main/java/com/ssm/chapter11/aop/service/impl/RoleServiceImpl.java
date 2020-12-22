package com.ssm.chapter11.aop.service.impl;

import com.ssm.chapter11.aop.service.RoleService;
import com.ssm.chapter11.game.pojo.Role;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter11-RoleServiceImpl
 * Description  
 *
 * @author      xuanc
 * @date        19-5-24 下午9:50
 * @version     1.0
 */
@Component
public class RoleServiceImpl implements RoleService {

    @Override
    public void printRole(Role role) {
        System.out.println("{id : " + role.getId() + ", " +
                "role_name : " + role.getRoleName() + ", " +
                "note : " + role.getNote() + "}");
    }
}
