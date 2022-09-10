# JDBC

- JDBC 就是使用 Java 语言操作关系型数据库的一套 API

  ![image-20220910141315534](img/image-20220910141315534.png)

## 一、JDBC 简介

**JDBC 概念：**

- JDBC 就是使用 Java 语言操作关系型数据库的一套 API

- 全称：( Java DataBase Connectivity ) Java 数据库连接

**JDBC 本质：**

- 官方 ( sun公司 ) 定义的一套操作所有关系型数据库的规则，即接口
- 各个数据库厂商去实现这套接口，提供数据库驱动 jar 包
- 我们可以使用这套接口 ( JDBC ) 编程，真正执行的代码是驱动 jar 包中的实现类

**JDBC好处：**

- 各数据库厂商使用相同的接口，Java 代码不需要针对不同数据库分别开发
- 可随时替换底层数据库，访问数据库的 Java 代码基本不变

![image-20220910144505648](img/image-20220910144505648.png)

## JDBC 快速入门

0. 创建工程，导入驱动jar包
   `mysql-connector-java-5.1.48jar`

1. 注册取动

   ```java
   Class.forName("com.mysql.jdbc.Driver");
   ```

2. 获取连接

   ```java
   Connection conn = DriverManager.getConnection(url, username, password);
   ```

3. 定义5QL语句

   ```java
   String sql = "update...";
   ```

4. 获取执行SQL对象

   ```java
   Statement stmt = conn.createStatement();
   ```

5. 执行SQL

   ```java
   stmt.executeUpdate(sql);
   ```

6. 处埋返回结果
7. 释放资源

![image-20220910145014278](img/image-20220910145014278.png)