package com.itheima.jdbc;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC API 详解：Result
 */
class JDBCDemo4_Result {
    /*
     * 执行 DQL 语句
     *  */
    @Test
    public void testDML() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

        // 2. 获取链接
        // String url = "jdbc:mysql://127.0.0.1:3306/db1";
        // 如果默认端口为 3306 可以简写为：
        String url = "jdbc:mysql:///db1?serverTimezone=UTC";
        String username = "root";
        String password = "root";

        Connection con = DriverManager.getConnection(url, username, password);
        // 3. 定义 SQL
        String sql = "select * from account";

        // 4. 获取 statement 对象
        Statement stmt = con.createStatement();

        // 5. 执行 sql
        ResultSet res = stmt.executeQuery(sql);
        // 6. 处理结果，遍历 res 中的所有数据
        // 6.1 光标向下移动一行，判断当前行是否存在数据

        while (res.next()){
            // 6.2 获取数据 getXxx()
            int id = res.getInt(1);
            String name = res.getString(2);
            double money = res.getDouble(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------");
        }

        // 7. 关闭连接
        con.close();
        stmt.close();
        res.close();
    }
}