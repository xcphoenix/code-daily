package com.ssm.chapter14.service;

import com.ssm.chapter14.pojo.Role;
import org.springframework.stereotype.Component;

/**
 * ClassName    Chapter14-RoleService
 * Description  
 *
 * @author      xuanc
 * @date        19-5-15 下午7:40
 * @version     1.0
 */
public interface RoleService {

    public Role getRole(Long id);

}
