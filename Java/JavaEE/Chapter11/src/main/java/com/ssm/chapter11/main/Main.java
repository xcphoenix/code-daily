package com.ssm.chapter11.main;

import com.ssm.chapter11.aop.config.AopConfig;
import com.ssm.chapter11.aop.service.RoleService;
import com.ssm.chapter11.game.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName    Chapter11-Main
 * Description  
 *
 * @author      xuanc
 * @date        19-5-24 下午10:12
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = (RoleService)ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1L);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
        System.out.println("#################");
        role = null;
        roleService.printRole(role);
    }

}
