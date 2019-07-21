# Spring 与 Web 开发

使用 SpringBoot：

1. 创建 SpringBoot 应用，选中需要的模块
2. SpringBoot 默认将这些场景自动配置好，只需要在配置文件中指定少量配置
3. 自己编写业务逻辑代码



## SpringBoot 对静态资源的映射规则

```java
// org/springframework/boot/autoconfigure/web/ResourceProperties.java
@ConfigurationProperties(prefix = "spring.resources", ignoreUnknownFields = false)
public class ResourceProperties {
    // 可以设置与静态资源有关的设置，例如缓冲时间等
```



```java
// org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration.java
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
        return;
    }
    Duration cachePeriod = this.resourceProperties.getCache().getPeriod();
    CacheControl cacheControl = this.resourceProperties.getCache().getCachecontrol().toHttpCacheControl();
    if (!registry.hasMappingForPattern("/webjars/**")) {
        customizeResourceHandlerRegistration(registry.addResourceHandler("/webjars/**")
                                             .addResourceLocations("classpath:/META-INF/resources/webjars/")
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
    String staticPathPattern = this.mvcProperties.getStaticPathPattern();
    if (!registry.hasMappingForPattern(staticPathPattern)) {
        customizeResourceHandlerRegistration(registry.addResourceHandler(staticPathPattern)
                                             .addResourceLocations(getResourceLocations(this.resourceProperties.getStaticLocations()))
                                             .setCachePeriod(getSeconds(cachePeriod)).setCacheControl(cacheControl));
    }
}

// 配置首页
@Bean
public WelcomePageHandlerMapping welcomePageHandlerMapping(ApplicationContext applicationContext) {
    return new WelcomePageHandlerMapping(new TemplateAvailabilityProviders(applicationContext),
                                         applicationContext, getWelcomePage(), this.mvcProperties.getStaticPathPattern());
}

// 配置喜欢的图标
@Configuration
@ConditionalOnProperty(value = "spring.mvc.favicon.enabled", matchIfMissing = true)
public static class FaviconConfiguration implements ResourceLoaderAware {

    private final ResourceProperties resourceProperties;

    private ResourceLoader resourceLoader;

    public FaviconConfiguration(ResourceProperties resourceProperties) {
        this.resourceProperties = resourceProperties;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public SimpleUrlHandlerMapping faviconHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
      
 // 在静态文件夹中寻找
        mapping.setUrlMap(Collections.singletonMap("**/favicon.ico", faviconRequestHandler()));
        return mapping;
    }

    @Bean
    public ResourceHttpRequestHandler faviconRequestHandler() {
        ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
        requestHandler.setLocations(resolveFaviconLocations());
        return requestHandler;
    }

    private List<Resource> resolveFaviconLocations() {
        String[] staticLocations = getResourceLocations(this.resourceProperties.getStaticLocations());
        List<Resource> locations = new ArrayList<>(staticLocations.length + 1);
        Arrays.stream(staticLocations).map(this.resourceLoader::getResource).forEach(locations::add);
        locations.add(new ClassPathResource("/"));
        return Collections.unmodifiableList(locations);
    }
```

1. 所有 /webjars/\*\*，都去 classpath:/META-INF/resources/webjars/ 找资源；

   [webjars](https://www.webjars.org/)：以 jar 包的方式引入静态资源；

   在 ***webjars*** 这个网站上可以使用 maven 导入常用 js 库的 webjar

   ```xml
   <dependency>
       <groupId>org.webjars</groupId>
       <artifactId>jquery</artifactId>
       <version>3.4.1</version>
   </dependency>
   ```

   ![](https://gitee.com/PhoenixBM/FigureBed/raw/picgo/img/20190721132241.png)

   ![](https://gitee.com/PhoenixBM/FigureBed/raw/picgo/img/20190721131900.png)

2.  "/**" 访问当前项目的任何资源，对应

   - classpath:/META-INF/resources/
   - classpath:/resources/

   - classpath:/static/

   - classpath:/public/
   - /：当前项目根路径

   ```java
   public class ResourceProperties {
   
       private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/",
                                                                     "classpath:/resources/", "classpath:/static/", "classpath:/public/" };
   
       /**
   	 * Locations of static resources. Defaults to classpath:[/META-INF/resources/,
   	 * /resources/, /static/, /public/].
   	 */
       private String[] staticLocations = CLASSPATH_RESOURCE_LOCATIONS;
   ```

3. 欢迎页面的映射

4. 页面图标映射（可能需要清除浏览器缓存 - [Chrome 插件](https://chrome.google.com/webstore/detail/classic-cache-killer/kkmknnnjliniefekpicbaaobdnjjikfp)或者 <kbd>Shift+F5</kbd>）

   需要放在映射路径的根目录下才可以。

> By default, resources are mapped on `/**`, but you can tune that with the `spring.mvc.static-path-pattern` property. For instance, relocating all resources to `/resources/**` can be achieved as follows:
>
> ```
> spring.mvc.static-path-pattern=/resources/**
> ```
>
> You can also customize the static resource locations by using the `spring.resources.static-locations` property (replacing the default values with a list of directory locations). The root Servlet context path, `"/"`, is automatically added as a location as well.
>
> In addition to the “standard” static resource locations mentioned earlier, a special case is made for [Webjars content](https://www.webjars.org/). Any resources with a path in`/webjars/**` are served from jar files if they are packaged in the Webjars format.
>
> | ![[Tip]](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/images/tip.png) |
> | ------------------------------------------------------------ |
> | Do not use the `src/main/webapp` directory if your application is packaged as a jar. Although this directory is a common standard, it works **only** with war packaging, and it is silently ignored by most build tools if you generate a jar. |



## 模板引擎

Jsp、Thymeleaf、Velocity、Freemarker ... 

SpringBoot 如果以 jar 的形式打包，而且由于 SpringBoot 使用的是内嵌的 Tomcat ，所以 SpringBoot 推荐使用 ***Thymeleaf***.

### 引入Thymeleaf

pom.xml

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```



### Thymeleaf 语法

自动配置的默认规则：

```java
@ConfigurationProperties(prefix = "spring.thymeleaf")
public class ThymeleafProperties {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;

	public static final String DEFAULT_PREFIX = "classpath:/templates/";

	public static final String DEFAULT_SUFFIX = ".html";
```

只要把 html 放在 classpath:/templates/ 后，Thymeleaf 就会自动渲染。

使用：

1. 导入 thymeleaf 名称空间：

   ```html
   <html lang="zh" xmlns:th="http://www.thymeleaf.org">
   ```

2. 使用语法

   ```html
   <!DOCTYPE html>
   <html lang="zh" xmlns:th="http://www.thymeleaf.org">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
   </head>
   <body>
       <h1>SUCCESS</h1>
       <!-- 将 div 的内容设置为... -->
       <div th:text="${hello}">这是显示欢迎数据</div>
   </body>
   </html>
   ```

#### 语法规则

- `th:text` 改变当前元素里面的文本内容

   `th:` 任意 html 属性，来替换原生属性的值

   对应的行内写法：

   - `th:text` => `[[]]`

   - `th:utext` => `[()]`

   ![](https://gitee.com/PhoenixBM/FigureBed/raw/picgo/img/20190721160559.png)

   

- 表达式

  **Simple expressions:**（表达式语法）

  - Variable Expressions: `${...}`

    - 获取对象的属性，调用方法
    - 使用内置的基本对象
      - #ctx : the context object.
      - #vars: the context variables.
      - #locale : the context locale.
      - #request : (only in Web Contexts) the HttpServletRequest object.
      - #response : (only in Web Contexts) the HttpServletResponse object.
      - #session : (only in Web Contexts) the HttpSession object.
      - #servletContext : (only in Web Contexts) the ServletContext object.
    - 使用内置的工具对象
      - #execInfo : information about the template being processed.
      - #messages : methods for obtaining externalized messages inside variables expressions, in the same way as they
        would be obtained using #{…} syntax.
      - #uris : methods for escaping parts of URLs/URIs
      - #conversions : methods for executing the configured conversion service (if any).
      - #dates : methods for java.util.Date objects: formatting, component extraction, etc.
      - #calendars : analogous to #dates , but for java.util.Calendar objects.
      - #numbers : methods for formatting numeric objects.
      - #strings : methods for String objects: contains, startsWith, prepending/appending, etc.
      - #objects : methods for objects in general.
      - #bools : methods for boolean evaluation.
      - #arrays : methods for arrays.
      - #lists : methods for lists.
      - #sets : methods for sets.
      - #maps : methods for maps.
      - #aggregates : methods for creating aggregates on arrays or collections.
      - #ids : methods for dealing with id attributes that might be repeated (for example, as a result of an iteration).

  - Selection Variable Expressions: 

    `*{...}`（选择表达式）和`#{}` 功能相同，补充使用：配置 `th:object` 使用，可以直接引用 `th:object` 的属性

  - Message Expressions: `#{...}`

    获取国际化内容

  - Link URL Expressions: `@{...}`

    定义 url，里面可以使用变量等值

  - Fragment Expressions: `~{...}`

    片段引用表达式

    

    **Literals**（字面量）

    - Text literals: 'one text' , 'Another one!' ,…

    - Number literals: 0 , 34 , 3.0 , 12.3 ,…

    - Boolean literals: true , false

    - Null literal: null

    - Literal tokens: one , sometext , main ,…

      

    **Text operations:**（文本操作）

    - String concatenation: +

    - Literal substitutions: |The name is ${name}|

      

    **Arithmetic operations:**（数学运算）

    - Binary operators: + , - , * , / , %

    - Minus sign (unary operator): -

      

    **Boolean operations:**（布尔运算）

    - Binary operators: and , or

    - Boolean negation (unary operator): ! , not

      

    **Comparisons and equality:**（比较运算）

    - Comparators: > , < , >= , <= ( gt , lt , ge , le )

    - Equality operators: == , != ( eq , ne )

      

    **Conditional operators:**（条件运算）

    - If-then: (if) ? (then)

    - If-then-else: (if) ? (then) : (else)

    - Default: (value) ?: (defaultvalue)

      

    **Special tokens:**

    - Page 17 of 104
    - No-Operation: _