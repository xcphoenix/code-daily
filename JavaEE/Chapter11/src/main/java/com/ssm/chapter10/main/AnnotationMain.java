package com.ssm.chapter10.main;

import com.ssm.chapter10.annotation.config.ApplicationConfig;
import com.ssm.chapter10.annotation.pojo.Role;
import com.ssm.chapter10.annotation.service.RoleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ClassName    Chapter11-AnnotationMain
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午8:40
 * @version     1.0
 */
public class AnnotationMain {
    public static void main(String[] args) {
    //     ApplicationContext context =
    //             new AnnotationConfigApplicationContext(PojoConfig.class);
    //     Role role = context.getBean(Role.class);
    //     System.out.println(role.getId());

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Role role = context.getBean(Role.class);
        // RoleService roleService = context.getBean(RoleService.class);
        RoleService roleService = (RoleService) context.getBean("roleService3");
        roleService.printRoleInfo(role);
        context.close();
    }
}
