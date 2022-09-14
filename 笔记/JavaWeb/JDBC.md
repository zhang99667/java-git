# JDBC

- JDBC 就是使用 Java 语言操作关系型数据库的一套 API

  ![image-20220910141315534](img/image-20220910141315534.png)

## 一、JDBC 简介

**JDBC 概念：**

- JDBC 就是使用 Java 语言操作关系型数据库的一套 API

- 全称：( **J**ava **D**ata**B**ase **C**onnectivity ) Java 数据库连接

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

## 二、JDBC API 详解

### DriverManager

- DriverManager (驱动管理类) 作用：

  1. 注册驱动

     ```java
     Class.forName("com.mysql.cj.jdbc.Driver");
     ```

     提示：

     - MySQL5 之后的驱动包，可以省略注册驱动的步骤
     - 自动加载 jar 包中 `META-lNF/services/java.sql.Driver` 文件中的驱动类

  2. 获取数据库连接

| static Connection | getConnection (String url, String user, String password) |
| ----------------- | -------------------------------------------------------- |

- 参数

  1. url: 连接路径

     > 语法：`jdbc:mysql://ip地址（域名）:端口号数据库名称?参数键值对1 & 参数键值对2...`
     > 示例：`jdbc:mysql://127.0.0.1:3306/db1`
     > 细节：
     >
     > - 如果连接的是本机 mysql 服务器，并且 mysql 服务默认端口是 3306，则 url 可以简写为：`jdbc:mysql:///数据库名称?参数键值对`
     > - 配置 useSSL=false 参数，禁用安全连接方式，解决警告提示

  2. user: 用户名

  3. password: 密码

### Connection

- Connection (数据库连接对象) 作用：

  1. 获取执行 SQL 的对象

     - 普通执行 SQL 对象

       `Statement createStatement ()`

     - 预编译 SQL 的执行 SQL 对象：防止 SQL 注入

       `PreparedStatement prepareStatement (sql)`

     - 执行存储过程的对象

       `CallableStatement prepareCall (sql)`

  2. 管理事务

     - MySQL事务管理

       > 开启事务：`BEGIN;` / `START TRANSACTION;`
       >
       > 提交事务：`COMMIT;`
       >
       > 回滚事务：`ROLLBACK;`
       >
       > MySQL 默认 **自动提交** 事务

     - JDBC 事务管理：Connection 接口中定义了 3 个对应的方法

       > 开启事务：`setAutoCommit(boolean autoCommit):true` 为自动提交事务；`false` 为手动提交事务，即为开启事务
       >
       > 提交事务：`commit()`
       >
       > 回滚事务：`rollback()`

### Statement

- Statement 作用：
  1. 执行SQL语句

- 执行SQL语句

  > `int executeUpdate (sql)`: 执行 DML、DDL 语句
  >
  > 返回值：(1) DML 语句影响的行数 (2) DDL 语句执行后，执行成功也可能返回 0

  > `ResultSet executeQuery (sql)`: 执行 DQL 语句
  >
  > 返回值：ResultSet 结果集对象

### ResultSet

- ResultSet (结果集对象) 作用：

  1. 封装了 DQL 查询语句的结果

  > `ResultSet stmt..executeQuery(sgl)`：执行 DQL 语句，返回 ResultSet 对象

- 获取查询结果

  > `boolean next ()`：(1) 将光标从当前位置向前移动一行 (2) 判断当前行是否为有效行
  >
  > 返回值：
  >
  > `true`：有效行，当前行有数据
  >
  > `false`：无效行，当前行没有数据

  

  > `XXX getXxx (参数)`：获取数据
  >
  > xxx：数据类型；如：`int getInt (参数)`；`String getString (参数)`
  > 参数：
  >
  > - int：列的编号，从1开始
  > - String：列的名称
