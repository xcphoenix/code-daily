package com.ssm.chapter14.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssm.chapter14.pojo.Role;

/**
 * ClassName    Chapter14-RoleDao
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-16 下午10:03
 */
@Component
public interface RoleDao {

    public Role getRole(Long id);
}
