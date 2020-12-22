import com.ssm.chapter12.mapper.RoleMapper;
import com.ssm.chapter12.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName    Chapter12-MyBatisSpringTest
 * Description  测试
 *
 * @author      xuanc
 * @date        19-5-25 下午2:01
 * @version     1.0
 */
public class MyBatisSpringTest {

    /**
     * SqlSessionTemplate 比较繁琐..
     * MyBatis-Spring 提供了一个 MapperFactoryBean 类作为中介来解决问题
     */
    @Test
    public void testSql() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-config.xml");
        SqlSessionTemplate sqlSessionTemplate = ctx.getBean(SqlSessionTemplate.class);
        Role role = new Role();
        role.setRoleName("role_name_sqlSessionTemplate");
        role.setNote("note_sqlSessionTemplate");
        sqlSessionTemplate.insert("com.ssm.chapter12.mapper.RoleMapper.insertRole", role);
        Long id = role.getId();
    }

    @Test
    public void testSql1() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-config.xml");
        RoleMapper roleMapper = ctx.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("testSql1");
        role.setNote("note_sqlSessionTemplate");
        roleMapper.insertRole(role);
    }

}
