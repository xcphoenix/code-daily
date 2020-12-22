package com.ssm.chapter10.profile;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName    Chapter11-ProfileDataSource
 * Description  使用注解 @Profile 配置
 *
 * @author      xuanc
 * @date        19-5-23 下午9:49
 * @version     1.0
 */
@Component
public class ProfileDataSource {

    @Bean(name = "devDataSource")
    @Profile("dev")
    public DataSource getDevDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/chapter12");
        props.setProperty("username", "root");
        props.setProperty("password", "mysqlpass");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "testDataSource")
    @Profile("test")
    public DataSource getTestDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/chapter13");
        props.setProperty("username", "root");
        props.setProperty("password", "mysqlpass");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}
