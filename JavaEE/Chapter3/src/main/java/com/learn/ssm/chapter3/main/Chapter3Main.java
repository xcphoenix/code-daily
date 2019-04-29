package com.learn.ssm.chapter3.main;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import com.learn.ssm.*;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

/**
 * ClassName    Chapter3-Chapter3Main
 * Description  运行代码
 *
 * @author      xuanc
 * @date        19-4-28 下午9:59
 * @version     1.0
 */ 
public class Chapter3Main {

    public static void main(String[] args) {
        Logger log = Logger.getLogger(Chapter3Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            log.info(role.getRoleName());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
