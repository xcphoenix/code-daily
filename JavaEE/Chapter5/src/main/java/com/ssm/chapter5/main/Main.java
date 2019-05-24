package com.ssm.chapter5.main;

import com.ssm.chapter5.mapper.EmployeeMapper;
import com.ssm.chapter5.pojo.Employee;
import com.ssm.chapter5.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 * ClassName    chapter5-Main
 * Description  测试
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-13 下午4:50
 */
public class Main {

    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
                Logger logger = Logger.getLogger(Main.class);
                sqlSession =SqlSessionFactoryUtils.openSqlSession();
                EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
                Employee employee = employeeMapper.getEmployee(1L);
                logger.info(employee.getBirthday());
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }


    }

}
