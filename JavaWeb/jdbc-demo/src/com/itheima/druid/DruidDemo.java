package com.itheima.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 1. 导入 Jar 包

        // 2. 定义配置文件

        // 3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("JavaWeb/jdbc-demo/src/druid.properties"));

        // 4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5. 获取数据库连接 Connection
        Connection con = dataSource.getConnection();

        System.out.println(System.getProperty("user.dir"));
        System.out.println(con);

        con.close();
    }
}
