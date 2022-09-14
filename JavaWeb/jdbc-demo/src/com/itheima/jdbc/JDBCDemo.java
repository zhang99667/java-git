package com.itheima.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC 快速入门
 */
class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

        // 2. 获取链接
        // String url = "jdbc:mysql://127.0.0.1:3306/db1";
        // 如果默认端口为 3306 可以简写为：
        String url = "jdbc:mysql:///db1?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);

        // 3. 定义 sql
        String sql = "UPDATE account SET money = 1000 WHERE id=1";

        // 4. 获取执行 sql 的对象 Statement
        Statement stmt = con.createStatement();
        // 5. 执行 sql
        int count = stmt.executeUpdate(sql);

        // 6. 处理结果
        System.out.println("Affected rows: "+count);

        // 7. 释放资源
        stmt.close();
        con.close();
    }
}