package com.itheima.jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/*
 * JDBC API 详解：Result
 */
public class JDBCDemo4_ResultSet {
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

        while (res.next()) {
            // 6.2 获取数据 getXxx()
            int id = res.getInt(1);
            String name = res.getString(2);
            double money = res.getDouble(3);
            System.out.println(id + "\t" + name + "\t" + money);
        }

        // 7. 关闭连接
        con.close();
        stmt.close();
        res.close();
    }

    /*
     * 查询 account 账户表数据，封装为 Account 对象中，并且存储 ArrayList 集合中
     * 1. 走义实体类 Account
     * 2. 查询数据，封装 Account 对象中
     * 3. 将 Account 对象存入 ArrayList 集合中
     * */
    @Test
    public void testResultSet() throws Exception {
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

        // 创建集合
        List<Account> list = new ArrayList<>();

        while (res.next()) {
            Account account = new Account();
            // 6.2 获取数据 getXxx()
            account.setId(res.getInt(1));
            account.setName(res.getString(2));
            account.setMoney( res.getDouble(3));
            list.add(account);
        }
        // 打印输出
        for (Account account:list)
            System.out.println(account);

        // 7. 关闭连接
        con.close();
        stmt.close();
        res.close();
    }
}