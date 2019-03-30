# Junit 5 学习笔记

> Junit4 文档太少了......
>
> 幸好发现了 Junit5 有[中文文档](https://sjyuan.cc/junit5/user-guide-cn/)



## 概述

### Junit 5 是什么

> JUnit 5跟以前的JUnit版本不一样，它由几大不同的模块组成，这些模块分别来自三个不同的子项目。
>
> **JUnit 5** = **JUnit Platform** + **JUnit Jupiter** + **JUnit Vintage**
>
> **JUnit Platform** 是在JVM上 [启动测试框架](https://sjyuan.cc/junit5/user-guide-cn/#71-junit-platform%E5%90%AF%E5%8A%A8%E5%99%A8api) 的基础平台。它还定义了 [TestEngine](https://junit.org/junit5/docs/5.3.0/api/org/junit/platform/engine/TestEngine.html) API，该API可用于开发在平台上运行的测试框架。此外，平台还提供了一个从命令行或者 [Gradle](https://sjyuan.cc/junit5/user-guide-cn/#421-gradle) 和 [Maven](https://sjyuan.cc/junit5/user-guide-cn/#422-maven) 插件来启动的 [控制台启动器](https://sjyuan.cc/junit5/user-guide-cn/#43-%E6%8E%A7%E5%88%B6%E5%8F%B0%E5%90%AF%E5%8A%A8%E5%99%A8) ，它就好比一个 [基于JUnit 4的Runner](https://sjyuan.cc/junit5/user-guide-cn/#44-%E4%BD%BF%E7%94%A8junit-4%E8%BF%90%E8%A1%8Cjunit-platform) 在平台上运行任何`TestEngine`。
>
> **JUnit Jupiter** 是一个组合体，它是由在JUnit 5中编写测试和扩展的新 [编程模型](https://sjyuan.cc/junit5/user-guide-cn/#3-%E7%BC%96%E5%86%99%E6%B5%8B%E8%AF%95) 和 [扩展模型](https://sjyuan.cc/junit5/user-guide-cn/#5-%E6%89%A9%E5%B1%95%E6%A8%A1%E5%9E%8B)组成。另外，Jupiter子项目还提供了一个`TestEngine`，用于在平台上运行基于Jupiter的测试。
>
> **JUnit Vintage** 提供了一个`TestEngine`，用于在平台上运行基于JUnit 3和JUnit 4的测试。



### 要求

- 需要 Java 8 或更改的 jdk
- Junit 5 需要 `JUnit Platform`、`JUnit Jupiter`、`JUnit Vintage` 等组件
- 依赖于 *Guardian* JAR 文件和 *OpenTest4J* JAR 文件

maven 配置：

```xml
        <!--Junit5-->
        <dependency>
            <groupId>org.junit</groupId>
            <artifactId>junit-bom</artifactId>
            <version>5.3.0</version>
        </dependency>
        <!--依赖-->
        <dependency>
            <groupId>org.apiguardian</groupId>
            <artifactId>apiguardian-api</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.opentest4j</groupId>
            <artifactId>opentest4j</artifactId>
            <version>1.0.0</version>
        </dependency>
```



## 编写测试



