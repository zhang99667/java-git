package com.itheima.jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
 * JDBC API 详解：Result
 */
public class JDBCDemo5_UserLogin {
    /*
     * 执行 DQL 语句
     *  */
    @Test
    public void testUserLogin() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

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

        // 拼接 SQL 字符串
        // username = 'name' and password = 'pwd';
        String sql = "SELECT * FROM tb_user WHERE username = '" + name +
                "' AND password = '" + pwd + "';";

        // 获取 stmt 对象
        Statement stmt = con.createStatement();
        // 执行 SQL
        ResultSet res = stmt.executeQuery(sql);

        // 判断登陆成功
        // 如果有查询到的数据，则登陆成功
        if (res.next()) System.out.println("登陆成功！");
        else System.out.println("登陆失败");
        // 7. 关闭连接
        con.close();
        stmt.close();
        res.close();
    }

    /*
    * 演示 SQL 注入
    *  */
    @Test
    public void testUserLogin_Inject() throws Exception {
        // 2. 获取链接
        // 如果默认端口为 3306 可以简写为：
        String url = "jdbc:mysql:///test?serverTimezone=UTC";
        String username = "root";
        String password = "root";

        // 接收用户输入的用户名和密码
        String name = "zhangsan";
        // SQL 注入
        String pwd = "' or '1' = '1";

        // 创建连接
        Connection con = DriverManager.getConnection(url, username, password);

        // 拼接 SQL 字符串
        // username = 'name' and password = 'pwd';
        String sql = "SELECT * FROM tb_user WHERE username = '" + name +
                "' AND password = '" + pwd + "';";

        // 输入 SQL 语句
        System.out.println(sql);
        // 获取 stmt 对象
        Statement stmt = con.createStatement();
        // 执行 SQL
        ResultSet res = stmt.executeQuery(sql);

        // 判断登陆成功
        // 如果有查询到的数据，则登陆成功
        if (res.next()) System.out.println("登陆成功！");
        else System.out.println("登陆失败");
        // 7. 关闭连接
        con.close();
        stmt.close();
        res.close();
    }
}