package auto.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration => Java 配置类
// @ComponentScan => 启用组件扫描（不加注解 Spring 默认不启用）
//                   再没有其他配置的话默认扫描与配置类相同的包
//                   使得 Spring 发现 @Component 并自动创建 bean
//                   ----------------------------------------
//                   @ComponentScan("package name) 在 value 属性中指定包的名称
//                   @ComponentScan(basePackages="package")
//                   @ComponentScan(basePackages={"package1", "package2", ...})  以 String 类型导入基础包，但类型不安全，即不方便重构代码
//                   @ComponentScan(basePackageClasses = {Class1.class, Classes2.class, ...} 这些类所在的包会最为组件扫描的基础包
/**
 * ClassName    Chapter2-CDPlayConfig
 * @author xuanc
 * @version 1.0
 * @date 19-3-18 下午10:11
 */
@Configuration
@ComponentScan
public class CDPlayConfig {
}
