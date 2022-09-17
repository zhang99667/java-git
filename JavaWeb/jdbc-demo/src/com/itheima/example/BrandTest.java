package com.itheima.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.pojo.Brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrandTest {
    /*
     * 查询所有
     *  */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println(System.getProperty("user.dir"));

        // 2. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        // 3. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 4. 获取 Connection 连接
        Connection con = dataSource.getConnection();

        // 5. 定义 SQL 语句
        String sql = "SELECT * FROM tb_brand;";

        // 6. 获取 pstmt 对象 (预编译)
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 7. 执行 sql
        ResultSet res = pstmt.executeQuery();
        List<Brand> brands = new ArrayList<>();

        while (res.next()) {
            // 封装 brand 对象
            Brand brand = new Brand();
            brand.setBrandName(res.getString("brand_name"));
            brand.setDescription(res.getString("description"));
            brand.setId(res.getInt("id"));
            brand.setStatus(res.getInt("status"));
            brand.setCompanyName(res.getString("company_name"));
            brand.setOrdered(res.getInt("ordered"));

            // 装载集合
            brands.add(brand);
        }

        // 8. 断开连接
        pstmt.close();
        res.close();
        con.close();

        for (Brand brandList : brands) System.out.println(brandList);
    }

    /*
     * 添加
     *  */
    @Test
    public void testAdd() throws Exception {
        // 接收页面的数据
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        // 2. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        // 3. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 4. 获取 Connection 连接
        Connection con = dataSource.getConnection();

        // 5. 定义 SQL 语句
        String sql = "INSERT INTO tb_brand (brand_name, company_name, ordered, description, status) VALUES (?, ?, ?, ?, ?);";

        // 6. 获取 pstmt 对象 (预编译)
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 7. 设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);

        // 8. 执行 sql
        int count = pstmt.executeUpdate(); // 影响的行数
        System.out.println(count > 0); // 输出一个 Boolean 值

        // 9. 断开连接
        pstmt.close();
        con.close();
    }

    /*
     * 修改
     *  */
    @Test
    public void testUpdate() throws Exception {
        // 接收页面的数据
        String brandName = "香飘飘";
        String companyName = "香飘飘奶茶";
        int ordered = 100;
        String description = "绕地球一圈";
        int status = 1;
        int id = 4;

        // 2. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        // 3. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 4. 获取 Connection 连接
        Connection con = dataSource.getConnection();

        // 5. 定义 SQL 语句
        String sql = "UPDATE tb_brand SET " +
                "brand_name = ?, " +
                "company_name = ?, " +
                "ordered = ?, " +
                "description = ?, " +
                "status = ? " +
                "WHERE id = ?;";

        // 6. 获取 pstmt 对象 (预编译)
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 7. 设置参数
        pstmt.setString(1, brandName);
        pstmt.setString(2, companyName);
        pstmt.setInt(3, ordered);
        pstmt.setString(4, description);
        pstmt.setInt(5, status);
        pstmt.setInt(6, id);

        // 8. 执行 sql
        int count = pstmt.executeUpdate(); // 影响的行数
        System.out.println(count > 0); // 输出一个 Boolean 值

        // 9. 断开连接
        pstmt.close();
        con.close();
    }

    /*
     * 删除
     *  */
    @Test
    public void testDelete() throws Exception {
        // 接收页面的数据
        int id = 4;

        // 2. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        // 3. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 4. 获取 Connection 连接
        Connection con = dataSource.getConnection();

        // 5. 定义 SQL 语句
        String sql = "DELETE FROM tb_brand WHERE id = ?;";

        // 6. 获取 pstmt 对象 (预编译)
        PreparedStatement pstmt = con.prepareStatement(sql);

        // 7. 设置参数
        pstmt.setInt(1, id);

        // 8. 执行 sql
        int count = pstmt.executeUpdate(); // 影响的行数
        System.out.println(count > 0); // 输出一个 Boolean 值

        // 9. 断开连接
        pstmt.close();
        con.close();
    }
}