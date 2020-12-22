package com.learn.ssm.chapter3.mapper;

import com.learn.ssm.chapter3.pojo.Role;

import java.util.List;

/**
 * ClassName    Chapter3-Role
 * Description  映射器接口
 *
 * @author      xuanc
 * @date        19-4-26 下午7:39
 * @version     1.0
 */ 
public interface RoleMapper {
    public int insertRole(Role role);
    public int deleteRole(Long id);
    public int updateRole(Role role);
    public Role getRole(Long id);
    public List<Role> findRoles(String roleName);
}
