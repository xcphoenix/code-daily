package xuanc.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * ClassName    Chapter3-DevelopmentProfileConfig
 * Description  配置 profile bean
 * ----------------------------------------------
 *              使用类级别的 @Profile 注解，来告诉 Spring 这个配置类中的 bean 创建在 dev profile 激活时
 * @author xuanc
 * @version 1.0
 * @date 19-3-31 下午10:00
 */
@Configuration
@Profile("dev")
public class DevelopmentProfileConfig {

    @Bean(destroyMethod = "")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }
}
