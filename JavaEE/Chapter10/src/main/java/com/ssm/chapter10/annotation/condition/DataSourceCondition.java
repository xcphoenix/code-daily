package com.ssm.chapter10.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * ClassName    Chapter11-DataSourceCondition
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-5-24 下午3:03
 */
public class DataSourceCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取上下文环境
        Environment env = conditionContext.getEnvironment();
        // 判断是否存在关于数据源的基础配置
        return env.containsProperty("jdbc.database.driver")
                && env.containsProperty("jdbc.database.url")
                && env.containsProperty("jdbc.database.username")
                && env.containsProperty("jdbc.database.password");
    }
}
