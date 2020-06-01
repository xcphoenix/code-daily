package xuanc.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * ClassName    Chapter3-ProductionProfileConfig
 * Description  生产环境的配置
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-31 下午10:13
 */
@Configuration
@Profile("prod")
public class ProductionProfileConfig {

    @Bean
    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDs");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource)jndiObjectFactoryBean.getObject();
    }
}
