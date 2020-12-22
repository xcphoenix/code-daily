package xuanc.habuma.restfun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName    Chapter3-IsWindowsCondition
 * Description  测试是否为 Windows 系统
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午8:45
 */
public class IsWindowsCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.getProperty("os.name").contains("Windows");
    }

}
