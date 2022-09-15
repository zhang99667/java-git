package com.itheima.jdbc;

import org.junit.Test;

import java.sql.*;

/*
 * JDBC API 详解：Result
 */
public class JDBCDemo6_PreparedStatement {
    /*
     * 执行 DQL 语句
     *  */
    @Test
    public void testUserLogin() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

        // 2. 获取链接
        // String url = "jdbc:mysql://127.0.0.1:3306/db1";
        // 如果默认端口为 3306 可以简写为：
        String url = "jdbc:mysql:///test?serverTimezone=UTC";
        String username = "root";
        String password = "root";

        // 接收用户输入的用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        // 创建连接
        Connection con = DriverManager.getConnection(url, username, password);

        // 利用占位符预填写
        String sql = "SELECT * FROM tb_user WHERE username = ? and password = ?;";

        // 获取 pstmt 对象
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 设置 ? 的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
        // 执行 SQL 语句
        ResultSet res = pstmt.executeQuery();
        if (res.next()) System.out.println("登陆成功");
        else System.out.println("登陆失败");

        // 7. 关闭连接
        con.close();
        pstmt.close();
        res.close();
    }

    /*
    * PreparedStatement 原理
    * */
    @Test
    public void testPreparedStatement() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

        // 2. 获取链接
        // String url = "jdbc:mysql://127.0.0.1:3306/db1";
        // 如果默认端口为 3306 可以简写为：
        // useServerPrepStmts=true 参数开启预编译功能
        String url = "jdbc:mysql:///test?serverTimezone=UTC&useServerPrepStmts=true";
        String username = "root";
        String password = "root";

        // 接收用户输入的用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        // 创建连接
        Connection con = DriverManager.getConnection(url, username, password);

        // 利用占位符预填写
        String sql = "SELECT * FROM tb_user WHERE username = ? and password = ?;";

        // 获取 pstmt 对象
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 设置 ? 的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
        // 执行 SQL 语句
        ResultSet res = pstmt.executeQuery();
        if (res.next()) System.out.println("登陆成功");
        else System.out.println("登陆失败");

        // 7. 关闭连接
        con.close();
        pstmt.close();
        res.close();
    }
}