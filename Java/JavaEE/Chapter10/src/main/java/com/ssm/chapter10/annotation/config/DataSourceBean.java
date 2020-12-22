package com.ssm.chapter10.annotation.config;

import com.ssm.chapter10.annotation.condition.DataSourceCondition;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ClassName    Chapter11-DataSourceBean
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-24 下午2:51
 */
@Component
public class DataSourceBean {

    /*
     * 通过 @Value，使用占位符来引用加载进来的属性
     */

    // @Value("${jdbc.database.driver}")
    // private String driver = null;
    //
    // @Value("${jdbc.database.url}")
    // private String url = null;
    //
    // @Value("${jdbc.database.username}")
    // private String username = null;
    //
    // @Value("${jdbc.database.password}")
    // private String password = null;
    //
    // @Bean(name = "dataSource")
    // public DataSource getDataSource() {
    //     Properties props = new Properties();
    //     props.setProperty("driver", driver);
    //     props.setProperty("url", url);
    //     props.setProperty("username", username);
    //     props.setProperty("password", password);
    //     DataSource dataSource = null;
    //
    //     try {
    //         dataSource = BasicDataSourceFactory.createDataSource(props);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //
    //     return dataSource;
    // }

    @Bean(name = "dataSource")
    @Conditional({DataSourceCondition.class})
    public DataSource getDataSource(
            @Value("${jdbc.database.driver}") String driver,
            @Value("${jdbc.database.url}") String url,
            @Value("${jdbc.database.username}") String username,
            @Value("${jdbc.database.password}") String password
    ) {
            Properties props = new Properties();
            props.setProperty("driver", driver);
            props.setProperty("url", url);
            props.setProperty("username", username);
            props.setProperty("password", password);
            DataSource dataSource = null;

            try {
                dataSource = BasicDataSourceFactory.createDataSource(props);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dataSource;
    }

}
