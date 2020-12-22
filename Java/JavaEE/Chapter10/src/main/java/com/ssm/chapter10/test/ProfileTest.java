package com.ssm.chapter10.test;

import com.ssm.chapter10.annotation.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * ClassName    Chapter11-ProfileTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-23 下午10:09
 * @version     1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@ActiveProfiles("dev")
public class ProfileTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() {
        System.out.println(dataSource.getClass().getName());
    }

}
