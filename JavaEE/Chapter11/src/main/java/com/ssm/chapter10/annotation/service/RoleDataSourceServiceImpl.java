package com.ssm.chapter10.annotation.service;

import com.ssm.chapter10.annotation.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ClassName    Chapter11-RoleDataSourceServiceImpl
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午9:33
 * @version     1.0
 */
@Component
public class RoleDataSourceServiceImpl implements RoleDataSourceService {

    @Autowired
    DataSource dataSource = null;

    @Override
    public Role getRole(Long id) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Role role = null;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(
                    "select id, role_name, note from t_role where id = ?"
            );
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getLong("id"));
                role.setRoleName(rs.getString("role_name"));
                role.setNote(rs.getString("note"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            /*
             * close dataSource resources ...
             */
        }
        return role;
    }
}
