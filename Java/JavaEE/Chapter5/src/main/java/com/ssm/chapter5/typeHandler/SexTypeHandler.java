package com.ssm.chapter5.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import com.ssm.chapter5.enumeration.SexEnum;

/**
 * ClassName    chapter5-SexTypeHandler
 * Description
 *
 * @author      xuanc
 * @date        19-5-12 下午4:54
 * @version     1.0
 */
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     * 获取可为空的结果集
     * @param rs 结果集
     * @param name 列名
     * @return SexEnum 枚举
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, String name) throws SQLException {
        int sex = rs.getInt(name);
        return SexEnum.getSexById(sex);
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, int index) throws SQLException {
        int sex = rs.getInt(index);
        return SexEnum.getSexById(sex);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int index) throws SQLException {
        int sex = cs.getInt(index);
        return SexEnum.getSexById(sex);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int index, SexEnum sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(index, sex.getId());
    }

}
