package com.itheima.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC 快速入门
 */
class JDBCDemo{
public static void main(String[] args) throws Exception{
    // 1. 注册驱动
    Class.forName("com.mysql.jdbc.Driver");

    // 2. 获取链接
    String url="jdbc:mysql://127.0.0.1:3306/db1";
    String username="root";
    String password="root";
    Connection con=DriverManager.getConnection(url,username,password);

    // 3. 定义 sql
    String sql = "update account set money = 2000 where id = 1";

    // 4. 获取执行 sql 的对象 Statement
    Statement stmt= con.createStatement();

    // 5. 执行 sql
    int count = stmt.executeUpdate(sql);

    // 6. 处理结果
    System.out.println(count);

    
    // 7. 释放资源
    stmt.close();
    con.close();
    
}}