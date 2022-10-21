

# Spring Framework

## Spring Framework 系统架构

Spring Framework 是 Spring 生态圈中最基础的项目，是其他项目的根基

![image-20221020191213476](img/image-20221020191213476.png)

## 核心概念

- 代码书写现状
  - 耦合度偏高
- 解决方案
  - 使用对象时，在程序中不要主动使用 new 产生对象，转换为由 **外部** 提供对象

![image-20221020192407330](img/image-20221020192407330.png)

### IoC (Inversion of Control) 控制反转

- 使用对象时，由主动 new 产生对象转换为由 **外部** 提供对象，此过程中对象创建控制权由程序转移到 **外部**，此思想称为 **控制反转**

### Spring 技术对 IoC 思想进行了买现

- Spring 提供了一个容器，称为 **IoC 容器**，用来充当 IoC 思想中的 **"外部"**
- IoC 容器负责对象的创建、初始化等一系列工作，被创建或被管理的对象在 IoC 容器中统称为 **Bean**

### DI (Dependency Injection) 依赖注入

- 在容器中建立 bean 与 bean 之间的依赖关系的整个过程，称为依赖注入

![image-20221020193458994](img/image-20221020193458994.png)

### 目标：**充分解耦**

- 使用 IoC 容器管理 bean (IoC)
- 在 IoC 容器内将有依赖关系的 bean 进行关系绑定 (DI)

### 最终效果

- 使用对象时不仅可以直接从 IoC 容器中获取，并且获取到的 bean 已经绑定了所有的依赖关系

## IoC 入门案例

### IoC 入门案例思路分析

1. 管理什么？（Service 与 Dao）
2. 如何将被管理的对象告知 IoC 容器？（配置)
3. 被管理的对象交给 IoC 容器，如何获取到 IoC 容器？（接口）
4. IoC 容器得到后，如何从容器中获取 bean？（接口方法）
5. 使用 Spring 导入哪些坐标？（pom.xml)

### IoC 入门案例（XML版)

#### 1. 配置 Maven 依赖

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.10.RELEASE</version>
</dependency>
```

#### 定义 Spring 管理的类（接口）

##### BookDao.java

```java
package com.itheima.dao;

public interface BookDao {
    void save();
}
```

##### BookDaoImpl.java

```java
package com.itheima.dao.impl;

import com.itheima.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao save...");
    }
}
```

##### BookService.java

```java
package com.itheima.service;

public interface BookService {
    void save();
}
```

##### BookServiceImpl.java

```java
package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.dao.impl.BookDaoImpl;
import com.itheima.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void save() {
        System.out.println("book service save...");
        bookDao.save();
    }
}
```

#### 3. 创建 Spring 配置文件，配置对应类作为 Spring 管理的 bean

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--1. 导入 spring 的坐标 spring-context，对应版本是 5.2.10.RELEASE-->
    <!--2. 配置 bean-->
    <!--bean 标签表示配置 bean-->
    <!--id 属性表示给 bean 起名字-->
    <!--class 属性表示给 bean 定义类型-->
    <bean id="bookDao" class="com.itheima.dao.impl.BookDaoImpl"/>
    <bean id="bookService" class="com.itheima.service.impl.BookServiceImpl"/>
</beans>
```

> bean 定义时 id 属性在同一个上下文中不能重复

#### 初始化 IoC 容器（Spring 核心容器 / Spring 容器），通过容器获取 bean

```java
package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2 {
    public static void main(String[] args) {
        // 获取 IoC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取 bean
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}
```

> **结论：还在 service 对象中 new 对象，故没解耦**



- 基于 IoC 管理 bean
- Service 中使用 new 形式创建的 Dao 对象是否保留？（否)
- Service 中需要的 Dao 对象如何进入到 Service 中？（提供方法）
- Service 与 Dao 间的关系如何描述？（配置)

## Spring Boot 概述

### Spring Boot 概念

Spring Boot 提供了一种快速使用 Spring 的方式，基于约定优于配置的思想，可以让开发人员不必在配置与逻辑业务之间进行思维的切换，全身心的投入到逻辑业务的代码编写中，从而大大提高了开发的效率，一定程度上缩短了项目周期。2014 年 4 月，Spring Boot1.0.0 发布。Spring 的顶级项目之一 (https:/spring.io)。

![image-20221020180934234](img/image-20221020180934234.png)

## SpringBoot 快速入门

## SpringBoot 起步依赖原理分析

## SpringBoot 配置

## SpringBoot 整合其他框架