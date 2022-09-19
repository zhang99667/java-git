package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAllBrand() throws IOException {
        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        // 接收参数
        int id = 1;

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        // 5. 释放资源
        sqlSession.close();
    }

 /*    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        // 封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法

        List<Brand> brands = brandMapper.selectByCondition(brand);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    } */

    @Test
    public void testSelectByCondition2() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Map brandMap = new HashMap<>();
        // brandMap.put("status",status);
        brandMap.put("companyName",companyName);
        brandMap.put("brandName",brandName);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法

        List<Brand> brands = brandMapper.selectByCondition(brandMap);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }
}
