# Spring Boot 配置

配置文件、加载顺序、配置原理

[TOC]

## 配置文件

SpringBoot 使用一个全局的配置文件：

- application.properties
- application.yml

配置文件的作用：修改 SpringBoot 自动配置的默认值。



以前的配置文件：使用的大多是 xml 文件。

yml 是YAML（YAML Ain't Markup Language）语言的文件，<u>以数据为中心</u>，更适合做配置文件



## YAML 语法

### 基本语法

key: value ==> 表示一对键值对（空格不能省略），且对大小写敏感。

以空格的缩进来控制层级关系；只要是左对齐的一列数据都是同一层级的数据

```yaml
server:
  	port: 8081
  	path: /hello
# 这是注释..  	
```

### 值的写法

- **字面量：普通的值（数字、字符串、布尔）**

  字面量直接写，字符串默认不用加上单引号或者双引号；

  "": 不会转义字符串的特殊字符，特殊字符作为本身要表示的意思

  ''：会转义特殊字符，特殊字符只是一个普通的字符串数据

- **对象、Map（属性和值）**

  Key: Value 对象还是键值对的形式，在下一行写对象的KV，但需要注意缩进

  ```yaml
  friends:
  	lastName: zhangsan
  	age: 20
  ```

  行内写法：

  ```yaml
  friends: {lastName: zhangshan, age: 18}
  ```

- **数组（List、Set）**

  用 `- 值` 表示数组中的一个元素

  ```yaml
  pets:
   - cat
   - dog
   - pig
  ```

  行内写法：

  ```yaml
  pets: [cat, dog, pig]
  ```

上面三种格式可以互相嵌套。



## 获取配置文件值

### 一、使用 @ConfigurationProperties

配置文件 

```yaml
person:
  lastName: zhangsan
  # 驼峰命名可以转化为横杠：last-name
  age: 18
  boss: false
  birth: 2017/12/12
  maps: {k1: v1, k2: v2}
  lists:
    - lisi
    - zhaoliu
  dog:
    name: 小狗
    age: 2
```

Java Bean

```java
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
    
```

还需要导入配置文件处理器，在 pom.xml 中加入：

```xml
		<!-- 配置文件处理器 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
```



同样，在 properties文件中也可以配置，但是在里面输入**中文会出现乱码**（Spring Boot 是以 iso-8859 的编码方式读取 application.properties 配置文件）。

解决方法：

> 1. 在 .properties 中加入:
>
>    ```properties
>    spring.http.encoding.force=true
>    spring.http.encoding.charset=UTF-8
>    spring.http.encoding.enabled=true
>    server.tomcat.uri-encoding=UTF-8
>    ```
>
> 2. 将 IDEA 设置中的 File Encodings 的 Transparent native-to-ascii conversion 打钩。



**属性名匹配规则**：

- person.firstName：使用标准方式
- person.first-name：大写用 -
- person.first_name：大写用\_
- PERSON_FIRST_NAME：
  - 推荐系统属性使用这种写法



### 二、使用 @Value

使用 Spring 底层注解 `@Value` 来实现，获取配置文件或环境变量的值，或使用 SpEL



### `@ConfigurationProperties` 和 `@Value` 区别

| Feature                    | `@ConfigurationProperties` | `@Value`                 |
| -------------------------- | -------------------------- | ------------------------ |
| 功能                       | 批量注入配置文件中的属性   | 一个个指定               |
| 松散绑定（属性名匹配规则） | 支持                       | 不支持                   |
| SpEL                       | 不支持                     | 支持                     |
| JSR303数据校验             | 支持（注入时校验数据）     | 不支持                   |
| 复杂类型封装               | 支持                       | 不支持（只支持基本类型） |

数据校验：

```java
@ConfigurationProperties(prefix = "person")
@Validated
public class Person {

    @Email
    private String lastName;
```

这样，如果 lastName 不是一个有效的 email 的话会抛出异常。



### 加载指定的配置文件

使用 `@PropertySource` 和 `@ImportResource` 可以记载指定的配置文件。

使用 `@ConfigurationProperties`  默认是从全局配置文件中获取值。



 **`@PropertySource`**： 加载指定的配置文件

```java
@PropertySource(value = {"classpath:person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
// @Validated
public class Person {

```

**`@ImportResource`**：导入 Spring 的配置文件，让配置文件里面的内容生效

SpringBoot 里面没有 Spring 的配置文件，自己编写的配置文件也不能自动识别，想让 Spring 的配置文件生效，加载进来，需要把 `@ImportResource` 标注在配置类上：

```java
@ImportResource(locations = {"classpath:beans.xml"})
@SpringBootApplication
public class SpringBoot02ConfigApplication {

```



SpringBoot 推荐的给容器添加组件的方式：

1. 编写配置类

2. 使用 `@Bean` 给容器中添加组件

   ```java
   @Configuration
   public class MyAppConfig {
   
       // bean 的 id 与方法名相同
       @Bean
       public HelloService helloService() {
           return new HelloService();
       }
   
   }
   ```

   

## 配置文件占位符

- RandomValuePropertySource：配置文件中可以使用随机数

  `${random.value}、${random.int}、${random.long}、${random.int(10)、${random.int[1024,65536]}`

- 属性配置占位符

  可以在配置文件中引用前面配置过的属性（优先级前面配置过得这里都能用）

  `${app.name: 默认值} `来指定找不到属性的默认值

  ```properties
  #person.last-name=张三${random.uuid}
  person.age=${random.int}
  person.birth=2017/12/12
  person.boss=false
  person.maps.k1=v1
  person.maps.k2=14
  person.lists=a,b,c,d
  person.dog.name=${person.last-name}_dog
  person.dog.age=15
  ```

  如果属性不存在，则会将占位符当做字符串处理



## Profile

Profile 是 Spring 对不同环境提供不同配置功能的支持，可以通过激活、指定参数等方式快速切换环境

### 多 profile 文件形式

格式：`application-{profile}.properties`

默认使用 application.properties 配置文件。

### YAML 文档块模式

YAML 中如果使用 `---` 可以将文件划分为不同的文档块，多个 profile 可以写在同一个文件中

```yaml
# Document1
server:
  port: 8081

person:
  lastName: zhangsan
  age: 18
  boss: false
  birth: 2017/12/12
  maps: {k1: v1, k2: v2}
  lists:
    - lisi
    - zhaoliu
  dog:
    name: 小狗
    age: 2

spring:
  profiles:
    active: dev # 指定激活哪一个 profile
---
# Document2
server:
  port: 8011
spring:
  profiles: dev # 指定文档块属于哪个 profile
---
# Document3
server:
  port: 8022
spring:
  profiles: prod
```



### 使用其他环境的配置文件的方式：

- application.properties 或 application.yml 指定

  > YAML 的优先级比 .properties 要低

  `spring.profiles.active={profile}`

  `spring:
    profiles:
      active: {profile}`

- 命令行方式（优先级较高）：

  idea 的 *program arguments* 设置 `-- spring.profiles.active={profile}`

  maven 打包后，在命令行执行并加上参数

- 虚拟机参数

  idea 的 *VM options*: `-Dspring.profiles.active={profile}` 



## 配置文件的加载位置



