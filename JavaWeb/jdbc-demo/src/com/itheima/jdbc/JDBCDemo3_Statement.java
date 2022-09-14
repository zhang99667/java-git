package com.itheima.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC API 详解：Statement
 */
class JDBCDemo {
    /*
     * 执行 DML 语句
     *  */
    @Test
    public void testDML() throws Exception {
        // 1. 注册驱动
        // Class.forName("com.mysql.cj.jdbc.Driver"); //  mysql-jdbc 8.0 可以去掉

        // 2. 获取链接
        // String url = "jdbc:mysql://127.0.0.1:3306/db1";
        // 如果默认端口为 3306 可以简写为：
        String url = "jdbc:mysql:///db1?serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection con = DriverManager.getConnection(url, username, password);

        // 3. 定义 sql
        String sql1 = "UPDATE account SET money = 3000 WHERE id=1";
        String sql2 = "UPDATE account SET money = 1000 WHERE id=2";

        // 4. 获取执行 sql 的对象 Statement
        Statement stmt = con.createStatement();

        // 开启事务
        try {
            // 5. 执行 sql1
            int count = stmt.executeUpdate(sql); // 执行完 DML 后，受影响的行数
            // 6. 处理结果1
            System.out.println("Affected rows: " + count);
            if (count > 0) System.out.println("修改成功");
            else System.out.println("修改失败");
            // 提交事务
            con.commit();
        } catch (Exception e) {
            // 回滚事务
            con.rollback;
            throw new RuntimeException(e);
        }

        // 7. 释放资源
        stmt.close();
        con.close();
    }
}