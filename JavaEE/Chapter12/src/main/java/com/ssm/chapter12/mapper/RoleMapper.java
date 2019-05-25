package com.ssm.chapter12.mapper;

import com.ssm.chapter12.pojo.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * ClassName    Chapter12-RoleMapper
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-25 下午1:35
 */
@Repository
public interface RoleMapper {

    public int insertRole(Role role);

    public Role getRole(@Param("id") Long id);

    public int updateRole(Role role);

    public int deleteRole(@Param("id") Long id);

}
