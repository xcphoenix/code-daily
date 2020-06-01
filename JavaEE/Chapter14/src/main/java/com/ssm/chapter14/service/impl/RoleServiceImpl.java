package com.ssm.chapter14.service.impl;

import com.ssm.chapter14.service.RoleService;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.chapter14.dao.RoleDao;
import com.ssm.chapter14.pojo.Role;
import com.ssm.chapter14.service.RoleService;

/**
 * @author xuanc
 */
@Component("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao = null;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

}
