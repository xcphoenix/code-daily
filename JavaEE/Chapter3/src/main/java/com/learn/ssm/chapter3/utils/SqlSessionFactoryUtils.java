package com.learn.ssm.chapter3.utils;

import java.io.IOException;
import java.io.InputStream;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ClassName    Chapter3-SqlSessionFactoryUtils
 * Description  构建 SqlSessionFactory
 *
 * @author      xuanc
 * @date        19-4-28 下午4:32
 * @version     1.0
 */ 
public class SqlSessionFactoryUtils {

    /**
     * 使用泛化Class引用生成带类型的目标实例
     */
    private final static Class<SqlSessionFactoryUtils> LOCK = SqlSessionFactoryUtils.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    /**
     * 构造方法设置为 private
     */
    private SqlSessionFactoryUtils() {}

    public static SqlSessionFactory getSqlSessionFactory() {
        /*
         * 除了方法前用synchronized关键字，synchronized关键字还可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。用法是: synchronized(this){/区块/}，它的作用域是当前对象。
         * 这时锁就是对象，谁拿到这个锁谁就可以运行它所控制的那段代码。当有一个明确的对象作为锁时，就可以这样写程序，但当没有明确的对象作为锁，只是想让一段代码同步时，可以创建一个特殊的instance变量（它得是一个对象）来充当锁：
         *
         * class Foo implements Runnable {
         *        private byte[] lock = new byte[0]; // 特殊的instance变量
         *        Public void methodA() {
         *          synchronized(lock) { //… }
         *        }
         *        //…..
         * }
         */
        synchronized (LOCK) {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
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
