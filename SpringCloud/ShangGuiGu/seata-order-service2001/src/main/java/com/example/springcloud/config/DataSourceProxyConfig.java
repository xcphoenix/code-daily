package com.example.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author      xuanc
 * @date        2020/5/26 上午10:34
 * @version     1.0
 */
@Configuration
public class DataSourceProxyConfig {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Bean
    // @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
    //
    // @Bean
    // public DataSourceProxy dataSourceProxy(DataSource dataSource) {
    //     return new DataSourceProxy(dataSource);
    // }
    //
    // @Bean
    // public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
    //     SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    //     sqlSessionFactoryBean.setDataSource(dataSourceProxy);
    //     sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
    //     sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
    //     return sqlSessionFactoryBean.getObject();
    // }

}