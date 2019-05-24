package com.ssm.chapter10.annotation.controller;

import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter11-RoleController2
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午9:03
 * @version     1.0
 */
@Component
public class RoleController2 {

    private RoleService roleService = null;

    /**
     * 装载带有参数的构造方法类
     * @param roleService RoleService bean
     */
    public RoleController2(@Qualifier("roleService3") RoleService roleService) {
        this.roleService = roleService;
    }

}
