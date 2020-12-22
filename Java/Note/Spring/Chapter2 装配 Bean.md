# Chapter2 装配 Bean

&emsp;&emsp;在 Spring 中，对象不需要自己查找或创建与其相关的其他对象，容器会负责把需要相互协作的对象引用赋予给各个对象。

&emsp;&emsp;创建应用对象之间协作关系的行为叫做 **装配**，而这也是依赖注入的本质。



## Spring 配置的可选方案

开发人员需要告诉 Spring 要创建哪些 bean 并怎样将其装配在一起。Spring 提供了三种主要的装配方式：

- XML 中显式配置
- Java 中显式配置
- 隐式的 bean 发现机制和自动装配

在 Spring 中，配置 bean 可以采用多种方式。

> 尽可能的使用自动配置的机制，减少显式配置。需要显式配置时建议使用 JavaConfig



## 自动化装配 bean

Spring 从两个角度来实现自动化装配：

- 组件扫描： 自动发现应用上下文中所创建的 bean
- 自动装配： 自动满足 bean 之间的依赖

---

#### 注解：

 `@Component` ： 表明该类会作为组件类，并且告诉 Spring 要为这个类创建 bean

Spring 上下文所有的 bean 都会有一个 ID，默认将类名的第一个字母小写当做其 ID
也可以使用 `@Component("ID 名") ` 来将期望的 ID 传给注解
也可以使用 Java 依赖注入规范所提供的 `@Named` 注解为 bean 设置 ID



---

`@Configuration `： Java 配置类



---

`@ComponentScan` ： 启用组件扫描（不加注解 Spring 默认不启用， 再没有其他配置的话默认扫描与配置类相同的包）使得 Spring 发现 @Component 并自动创建 bean

`@ComponentScan("package name") `在 value 属性中指定包的名称

`@ComponentScan(basePackages="package")` 

`@ComponentScan(basePackages={"package1", "package2", ...})`  以 String 类型导入基础包，但类型不安全，即不方便重构代码

`@ComponentScan(basePackageClasses = {Class1.class, Classes2.class, ...}` 这些类所在的包会最为组件扫描的基础包



---

`@RunWith(SpringJUnit4ClassRunner.class)`：使用 Spring 的 `SpringJUnit4ClassRunner `在测试开始的时候自动创建 Spring 的应用上下文

`@ContextConfiguration(classes = Class.class)`：告诉要在某个类中加载配置



`@Autowired`：声明进行自动装配，可以用在构造器上或是 Setter 方法上，使得 Spring 在初始化 bean 后会尽可能的满足 bean 的依赖，如果只有一个 bean 匹配依赖需求则会被装配，如果没有则会抛出异常（可以设置 `@Autowired` 的 `required` 属性设置为 `false`），多个 bean 满足也会抛出异常。（这个注解是 Spring 所特有的，可以使用 Java 依赖注入规范的 `@Inject` 来代替，大多数场景下可以互相替换）。