package xuanc.habuma.restfun;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName    Chapter3-MagicExistsCondition
 * Description  TODO
 * @author      xuanc
 * @date        19-4-1 下午8:22
 * @version     1.0
 */ 
public class MagicExistsCondition implements Condition {

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.containsProperty("magic");
    }

}
