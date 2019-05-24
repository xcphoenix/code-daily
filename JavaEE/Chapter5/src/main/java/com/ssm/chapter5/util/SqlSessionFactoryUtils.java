package com.ssm.chapter5.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName    chapter5-SqlSessionFactoryUtils
 * Description  
 *
 * @author      xuanc
 * @date        19-5-13 下午4:55
 * @version     1.0
 */ 
public class SqlSessionFactoryUtils {

    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    /**
     * 类实例
     */
    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 私有构造器，保证为单例类
     */
    private SqlSessionFactoryUtils() {}

    /**
     * 获取单例 SqlSessionFactory
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {

        /*
         * 加锁，防止在多线程中多次实例化 SqlSessionFactory 对象
         */
        synchronized (LOCK) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream ;
            try {
                inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }

}
