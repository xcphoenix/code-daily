# JUnit5 User Guide

## 编写测试

下面的示例包含了在JUnit Jupiter中编写测试的最低要求。在后面的章节中将会提供所有可用特性的相关细节。



*A first test case*

```java :file:com/junit5/example/Calculator.java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

```java :file:com/junit5/example/MyFirstJUnitJupiterTests.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstJUnitJupiterTests {

    private final Calculator calculator = new Calculator();

    @Test
    void addition() {
        assertEquals(2, calculator.add(1, 1));
    }

}
```

### 注解

JUnit Jupiter支持以下注释来配置测试和扩展框架。

除非另有说明，所有的核心注解都在 `junit-jupiter-api` 模块下的 [`org.junit.jupiter.api`](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/package-summary.html) 包中。



| Annotation               | Description                                                  |
| :----------------------- | :----------------------------------------------------------- |
| `@Test`                  | 表明被修饰的方法是测试方法，不同于JUnit4的`@Test`注解，这个注解不需要声明任何属性，因为在JUnit Jupiter 对测试的扩展操作基于其专有的注释。而这些方法是继承的，除非他们被重写。 |
| `@ParameterizedTest`     | 表明方法是参数化测试（ [parameterized test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests)）。 这些方法是继承的，除非他们被重写。 |
| `@RepeatedTest`          | 表明方法是一个重复测试的模板（[repeated test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests)）。这些方法是继承的，除非他们被重写。 |
| `@TestFactory`           | 表明方法是用于动态测试的测试工厂（[dynamic tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests)）。这些方法是继承的，除非他们被重写。 |
| `@TestTemplate`          | 表明方法是一个被设计为多次调用的测试用例（[template for test cases](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates)）的模板，具体取决于注册程序（[providers](https://junit.org/junit5/docs/current/user-guide/#extensions-test-templates)）返回的调用上下文的数量。这些方法是继承的，除非他们被重写。 |
| `@TestMethodOrder`       | 用来配置被注释的测试类中的测试方法的执行顺序（[test method execution order](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order)）。与JUnit 4的注解`@FixMethodOrder`相似。这样的注释是继承的。 |
| `@TestInstance`          | 用来配置测试类的测试实例生命周期（ [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle)） 。这样的注释是继承的。 |
| `@DisplayName`           | 为测试类或测试方法声明一个自定义的显示名称（ [display name](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names) ）。这样的注释不会继承。 |
| `@DisplayNameGeneration` | 为测试类定义一个自定义名称的生成器（[display name generator](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator)）。这样的注释是可以继承的。. |
| `@BeforeEach`            | 在当前类的每一个被 `@Test`, `@RepeatedTest`, `@ParameterizedTest`,  `@TestFactory` 所注释的方法执行前先执行被该注释执行的方法。 类似于JUnit 4的 `@Before`. 如果**方法**没有被覆盖，会继承下去。 |
| `@AfterEach`             | 在当前类的每一个被 `@Test`, `@RepeatedTest`, `@ParameterizedTest`,  `@TestFactory` 所注释的方法执行后都会执行被该注释执行的方法。 类似于JUnit 4的 `@Before`. 如果**方法**没有被覆盖，会继承下去。 |
| `@BeforeAll`             | 表示带注释的方法应该在当前类中的所有`@Test`、`@RepeatedTest`、`@ParameterizedTest`和`@TestFactory`方法之前执行；类似于junit4的 `@BeforeClass`。这些方法是继承的(除非它们被隐藏或覆盖)，并且必须是静态的(除非使用“每个类”的测试实例生命周期 [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) ）. |
| `@AfterAll`              | 表示在当前类中所有@Test、@RepeatedTest、@ParameterizedTest和@TestFactory方法执行之后都会执行被该注释修饰的方法；类似于JUnit 4 的 @AfterClass。这些方法是继承的(除非它们被隐藏或覆盖)，并且必须是静态的(除非使用“每个类”的测试实例生命周期)。 |
| `@Nested`                | 表明被注释的类是一个非静态嵌套测试类。`@BeforeAll` 和 `@AfterAll` 方法不能不能在被该注解所修饰的类中直接使用。除非使用每个类的测试实例周期（[test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle)）。该注解不会被继承。 |
| `@Tag`                   | 在类或方法级别声明用于过滤测试的标记（ [tags for filtering tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering)），类似于TestNG中的测试组或JUnit 4中的类别。注解在类级继承，但不在方法级继承。 |
| `@Disabled`              | 用来禁用测试类或测试方法（ [disable](https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling)），类似于 Junit4 中的 `@Ignore` ，注解不是继承的。 |
| `@Timeout`               | 在测试、测试工厂、测试模板或生命周期方法执行超过给定时间后会测试失败。注解是继承的。 |
| `@ExtendWith`            | 用于以声明方式注册扩展（[register extensions declaratively](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative)）。 这样的注释是继承的。 |
| `@RegisterExtension`     | 用于通过字段以编程方式注册扩展。这些字段将被继承，除非它们被隐藏。Used to （[register extensions programmatically](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-programmatic) ） |
| `@TempDir`               | 用于在生命周期方法或测试方法中通过字段注入或参数注入提供临时目录（[temporary directory](https://junit.org/junit5/docs/current/user-guide/#writing-tests-built-in-extensions-TempDirectory)）。在 `org.junit.jupiter.api.io` 包下。 |

> 一些注解可能是实验性的，详情参考：[Experimental APIs](https://junit.org/junit5/docs/current/user-guide/#api-evolution-experimental-apis) 

### 元注解和组合注解

>  可以注解到别的注解上的注解称为*元注解*，被注解的注解称为组合注解

JUnit Jupiter 可以用来作为元注解，这意味着你可以定义自己的组合注解，而且会自动继承元注解的语义。

例如，你可以创建一个叫 `@Fast` 的组合注解，而不是复制粘贴 `@Tag("fast")` ，之后就可以使用 `@Fast` 来替代 `@Tag("fast")`。

```java 
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
public @interface Fast {
}
```

甚至可以更近一步，自定义一个 `@FastTest` 注解来取代 `@Tag("fast")` 和 `@Test`

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
@Test
public @interface FastTest {
}
```

### 测试类和方法

**测试类**：包含至少一个测试方法的顶级类（非内部类，package 的成员）、静态成员类（在另一个类的主体内定义的成员类，并声明为*static*，不是内部类，但被视为顶级类）或者被 `@Nested` 修饰的类。

测试类不能是抽象的，而且必须只有一个构造器。

**测试方法**：使用`@Test`、`@RepeatedTest`、`@ParameterizedTest`、`@TestFactory`或`@TestTemplate`直接注释或元注解的任何实例方法。

**生命周期方法**：使用`@BeforeAll`、`@AfterAll`、`@BeforeEach`、`@AfterEach`直接注释，或者以元注解的形式注释的任何方法。(``@BeforeAll`、`@AfterAll` 所修饰的方法必须为类方法 - *static*)

测试方法和生命周期方法可以定义在当前类中，也可以继承自父类或接口。此外，测试方法和生命周期方法不能是抽象的，也不能有返回值。

> 测试类、测试方法和生命周期方法可以不是公有的（`public`），但不能是私有的（`private`）

下面的测试示例展示了`@Test` 方法和所有的生命周期方法的用法。

*A standard test class*

```java
public class StandardTests {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
```

> - `@Fail()` ：让测试失败，根据参数情况，使用指定的错误信息字符串或者抛出异常等 ~~ [API](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html)

### 显示名称

测试类和测试方法可以通过 `@DisplayName` 来在自定义显示名称，显示名称可以是空格，特殊字符，甚至是 emojis        表情，显示名称将会出现在测试报告和 IDE 的测试运行结果中。

```java
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("A special test case")
class DisplayNameDemo {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {
    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {
    }

    @Test
    @DisplayName("😱")
    void testWithDisplayNameContainingEmoji() {
    }

}
```

Idea 运行结果：

![](https://gitee.com/PhoenixXc/FigureBed/raw/picgo/img/20190823132015.png)

### 显示名称生成器

JUnit Jupiter 支持使用注解`@DisplayName`来自定义显示名称生成器。通过`@DisplayName`注解提供的值总是优先于由`DisplayNameGenerator`生成的显示名称。

```java
package com.junit5.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

public class DisplayNameGeneratorDemo {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for years is not supported by the leap year computation.")
        @ParameterizedTest(name = "For example, year {0} is not supported.")
        @ValueSource(ints = {-1, -4})
        void if_it_is_negative(int year) {
        }

    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class A_year_is_a_leap_year {

        @Test
        void if_it_is_divisible_by_4_but_not_by_100() {
        }

        @ParameterizedTest(name = "Year {0} is a leap year.")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {
        }

    }

    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return super.generateDisplayNameForClass(testClass);
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String name = testClass.getSimpleName() + ' ' + testMethod.getName();
            return name.replace('_', ' ') + '.';
        }
    }

}
```

测试结果：

![](https://gitee.com/PhoenixXc/FigureBed/raw/picgo/img/20190823171320.png)

> 此处有类和方法的命名不太规范，只是为了演示注解的作用

> - [`@ParameterizedTest`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/ParameterizedTest.html) 
>
>   该注解用来标记被注释的方法是参数化的测试方法。
>
>   被注释的方法不能是 `private` 或 `static` 的。
>
>   ---
>
>   被其注释的方法至少指定一个通过注解  [`@ArgumentsSource`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/provider/ArgumentsSource.html) 标示的参数提供者（ [`ArgumentsProvider`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/provider/ArgumentsProvider.html)），或者是使用一个像 `@ValueSource`、`@CsvSource` 这样的组合注解。提供程序负责提供一个参数流，该参数流将用于调用参数化测试方法。
>
>   - `name` 
>
>     用于参数化测试的单独调用的显示名称；不要为空或只由空白组成。
>
>     支持的占位符：
>
>     - [`DISPLAY_NAME_PLACEHOLDER`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/ParameterizedTest.html#DISPLAY_NAME_PLACEHOLDER)
>     - [`INDEX_PLACEHOLDER`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/ParameterizedTest.html#INDEX_PLACEHOLDER)
>     - [`ARGUMENTS_PLACEHOLDER`](https://junit.org/junit5/docs/5.3.0/api/org/junit/jupiter/params/ParameterizedTest.html#ARGUMENTS_PLACEHOLDER)
>     - `{0}`, `{1}`, etc.: an individual argument (0-based)
>
> - [`@ValueSource`](https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/params/provider/ValueSource.html)
>
>   @ValueSource是一个参数数据源，提供了对基本类型的文字值数组的访问。
>
>   支持以下类型：`double[]`、`int[]` 、`long[]`、`String[]`
>
>   对应的值：`ints`、`strings`、`longs`、`doubles`（都不能为空）

如上所说的，name 里面可以使用4种占位符：

```java
@DisplayName("A negative value for years is not supported by the leap year computation.")
@ParameterizedTest(name = "For example, year {0} is not supported. " +
                   "{displayName} + {index} + {arguments}")
@ValueSource(ints = {-1, -4})
void if_it_is_negative(int year) {
}
```

![](https://gitee.com/PhoenixXc/FigureBed/raw/picgo/img/20190823182355.png)

### 设置默认显示名称生成器

你可以使用`junit.jupiter.displayname.generator.default`这个配置参数来指定默认的显示名称生成器的完全限定类名。就像通过`@DisplayNameGeneration`注解配置的显示名称生成器一样，提供的类必须实现`DisplayNameGenerator`接口。默认显示名称生成器将用于所有测试，除非封闭的测试类或测试接口上存在`@DisplayNameGeneration`注解。通过`@DisplayName`注解提供的值总是优先于由`DisplayNameGenerator`生成的显示名称。

例如，要默认使用`ReplaceUnderscores`作为显示名称生成器，应将配置参数设置为相应的完全限定类名称：

```properties
junit.jupiter.displayname.generator.default = org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores
```

同样，可以指定实现了接口`DisplayNameGenerator`的任何自定义类的完全限定名。

总之，测试类或方法的显示名称是根据以下优先级规则确定的:

1. `@DisplayName`注解的值（如果存在）
2. 通过调用`@DisplayNameGeneration`注解中指定的DisplayNameGenerator（如果存在）
3. 通过调用通过配置参数配置的默认DisplayNameGenerator（如果存在）
4. 调用`org.junit.jupiter.api.DisplayNameGenerator.Standard`

## 断言

JUnit Jupiter附带了许多JUnit 4所拥有的断言方法，并添加了一些适合与Java 8 lambdas一起使用的方法。 所有JUnit Jupiter断言都是`org.junit.jupiter.api.Assertions`类中的静态方法。

```java
package com.junit5.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.*;

public class AssertionsDemo {

    private final Calculator calculator = new Calculator();

    @Test
    void testOnlyOnCiServer() {
        assumeTrue("CI".equals(System.getenv("ENV")));
    }

    @Test
    void testOnlyOnDeveloperWorkstation() {
        // if assumption is false, throw TestAbortedException with (String)message.get
        assumeTrue("DEV".equals(System.getenv("ENV")),
                () -> "Aborting test: not on developer workstation");
    }

    @Test
    void testInAllEnvironments() {
        assumingThat("CI".equals(System.getenv("ENV")),
                () -> {
                    // 不会执行...
                    assertEquals(4, calculator.divide(4, 2));
                });
        assertEquals(42, calculator.multiply(6, 7));
    }

}

```

## 禁用测试

所有的测试类和单个的测试方法，都可以使用注解`@Disabled`、自定义条件执行测试或者是在自定义执行条件来禁用。

这是`@Disabled`修饰类的例子：

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #99 has been fixed")
class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }

}
```

修饰方法：

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }

}
```

> 使用`@Disabled`可以不需要原因，但JUnit开发团队建议开发者应该提供一个为什么禁用测试方法或类的简要说明。

## 条件化的测试

JUnit Jupiter中的`ExecutionCondition`扩展API允许开发人员以编程方式基于某些条件启用或禁用容器或测试。 这种情况最简单的例子是内置的`DisabledCondition`，它支持@Disabled注释）。 除了@Disabled之外，JUnit Jupiter还支持`org.junit.jupiter.api.condition`包中的其他几个基于注释的条件，允许开发人员以声明方式启用或禁用容器和测试。 

> 请注意，以下部分中列出的任何条件注释也可以用作元注释，以便创建自定义组合注释。

> 以下部分中列出的每个条件注释只能在给定的测试接口，测试类或测试方法上声明一次。 如果条件注释在给定元素上直接存在，间接存在或元存在多次，则只使用JUnit发现的第一个这样的注释；任何其他声明都将被默认忽略。 但每个条件注释都可以与`org.junit.jupiter.api.condition`包中的其他条件注释一起使用。

### 操作系统条件

可以通过`@EnabledOnOs`和`@DisabledOnOs`注释在特定的操作系统上启用或禁用容器或测试。

```java
@Test
@EnabledOnOs(MAC)
void onlyOnMacOs() {
    // ...
}

@TestOnMac
void testOnMac() {
    // ...
}

@Test
@EnabledOnOs({ LINUX, MAC })
void onLinuxOrMac() {
    // ...
}

@Test
@DisabledOnOs(WINDOWS)
void notOnWindows() {
    // ...
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@EnabledOnOs(MAC)
@interface TestOnMac {
}
```

### Java 运行环境条件

可以通过`@EnabledOnJre`和`@DisabledOnJre`注释在特定版本的Java运行时环境（JRE）上启用或禁用容器或测试。

```java
@Test
@EnabledOnJre(JAVA_8)
void onlyOnJava8() {
    // ...
}

@Test
@EnabledOnJre({ JAVA_9, JAVA_10 })
void onJava9Or10() {
    // ...
}

@Test
@DisabledOnJre(JAVA_9)
void notOnJava9() {
    // ...
}
```

### 系统属性条件

一个容器或测试可以使用注解 `@EnabledIfSystemProperty` 或 ` @DisabledIfSystemProperty` 中的 `named` 属性，根据 JVM 系统属性来启用或者禁用 。通过`matches`属性提供的值将被解释为正则表达式。

```java
@Test
@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
void onlyOn64BitArchitectures() {
    // ...
}

@Test
@DisabledIfSystemProperty(named = "ci-server", matches = "true")
void notOnCiServer() {
    // ...
}
```

### 环境变量条件

一个容器或测试可以使用注解 `@EnabledIfEnvironmentVariable` 或 ` @DisabledIfEnvironmentVariable ` 中的 `named` 属性，根据底层操作系统的环境变量属性来启用或者禁用 。支持使用正则表达式设置 `match` 属性的值。

```java
@Test
@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
void onlyOnStagingServer() {
    // ...
}

@Test
@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
void notOnDeveloperWorkstation() {
    // ...
}
```

### 基于脚本的测试条件

> 在未来的版本中，使用 `@EnabledIf` 和 `@DisabledIf` 这两个注解的测试执行条件不推荐被弃用。

JUnit Jupiter 提供了在使用注解 `@EabledIf` 或 `@DisabledIf` 的情况下，通过可执行的脚本来配置容器或测试是否被启用的功能。脚本可以用JavaScript、Groovy或任何其他支持Java脚本API(由JSR 223定义)的脚本语言编写。

> 如果脚本的逻辑仅依赖于当前操作系统、当前的Java运行时环境版本、特定的JVM系统属性或特定的环境变量，您应该考虑使用专用于该目的的内置注释之一。

> 如果您发现自己多次使用相同的脚本条件，可以考虑实现[`ExecutionCondition`](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/extension/ExecutionCondition.html)接口，以便以更快、类型安全、更易于维护的方式实现该条件。

```java
@Test // Static JavaScript expression.
@EnabledIf("2 * 3 == 6")
void willBeExecuted() {
    // ...
}

@RepeatedTest(10) // Dynamic JavaScript expression.
@DisabledIf("Math.random() < 0.314159")
void mightNotBeExecuted() {
    // ...
}

@Test // Regular expression testing bound system property.
@DisabledIf("/32/.test(systemProperty.get('os.arch'))")
void disabledOn32BitArchitectures() {
    assertFalse(System.getProperty("os.arch").contains("32"));
}

@Test
@EnabledIf("'CI' == systemEnvironment.get('ENV')")
void onlyOnCiServer() {
    assertTrue("CI".equals(System.getenv("ENV")));
}

@Test // Multi-line script, custom engine name and custom reason.
@EnabledIf(value = {
                "load('nashorn:mozilla_compat.js')",
                "importPackage(java.time)",
                "",
                "var today = LocalDate.now()",
                "var tomorrow = today.plusDays(1)",
                "tomorrow.isAfter(today)"
            },
            engine = "nashorn",
            reason = "Self-fulfilling: {result}")
void theDayAfterTomorrow() {
    LocalDate today = LocalDate.now();
    LocalDate tomorrow = today.plusDays(1);
    assertTrue(tomorrow.isAfter(today));
}
```

#### 脚本绑定

以下名称绑定到每个脚本上下文，因此可在脚本中使用。 访问器可以通过简单的String get（String name）方法对类似map结构的值的访问。

| Name                          | Type          | Description                                     |
| :---------------------------- | :------------ | :---------------------------------------------- |
| `systemEnvironment`           | *accessor*    | Operating system environment variable accessor. |
| `systemProperty`              | *accessor*    | JVM system property accessor.                   |
| `junitConfigurationParameter` | *accessor*    | Configuration parameter accessor.               |
| `junitDisplayName`            | `String`      | Display name of the test or container.          |
| `junitTags`                   | `Set<String>` | All tags assigned to the test or container.     |
| `junitUniqueId`               | `String`      | Unique ID of the test or container.             |

## 标签和过滤

可以通过`@Tag`注解标记测试类和方法。 稍后可以使用这些标记来过滤测试发现和执行。

> 参考：标签表达式（ [Tag Expressions](https://junit.org/junit5/docs/current/user-guide/#running-tests-tag-expressions)）

### 标签的语法规则

- 标签必须非空（`null` 或 `''`）
- 标签被修剪后不能包含空格
- 标签被修剪后不能包含IsO控制字符
- 标签被修剪后不能包含以下任何一个保留字符：
  - ,
  - (
  - )
  - &
  - |
  - !

> 修剪（“trim”）表示删除了前面和后面的空格字符。

```java
@Tag("fast")
@Tag("model")
public class TaggingDemo {

    @Test
    @Tag("taxes")
    void testingTaxCalculation() {
    }
    
}
```

## 测试执行顺序

默认情况下，测试方法将使用确定性但有意不明显的算法进行排序。 这确保了测试套件的后续运行以相同的顺序执行测试方法，从而允许可重复的构建。

尽管单元测试不应该依赖于执行顺序，但是有时候强制执行顺序是必须的——例如，在编写集成测试或功能测试时，测试顺序很重要，特别是与`@TestInstance(Lifecycle.PER_CLASS)`结合使用。

为了控制测试方法的执行顺序，在测试类或接口上使用注解`@TestMethodOrder`并且指定想要的方法顺序的实现（ `MethodOrderer` ）。你可以实现你的自定义 `MethodOrderer` 或者使用内置的 `MethodOrder`实现。

- [`Alphanumeric`](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.Alphanumeric.html): 根据测试方法名和参数列表的字母数字排序
- [`OrderAnnotation`](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.OrderAnnotation.html): 通过注释在方法上的注解 `@Order`的值来排序
- [`Random`](https://junit.org/junit5/docs/current/api/org/junit/jupiter/api/MethodOrderer.Random.html): 伪随机排序测试方法，并支持自定义种子的配置

下面的示例演示了如何确保测试方法按照@Order注释指定的顺序执行。

