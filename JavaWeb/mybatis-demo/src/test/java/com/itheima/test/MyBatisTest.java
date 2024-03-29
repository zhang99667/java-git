package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.User;
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
        brandMap.put("companyName", companyName);
        brandMap.put("brandName", brandName);

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

    @Test
    public void testSelectByConditionSingle() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "华为";
        String companyName = "华为";

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        Brand brand = new Brand();
        // brand.setStatus(status);
 /*        brand.setBrandName(brandName);
        brand.setCompanyName(companyName); */

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法

        List<Brand> brands = brandMapper.SelectByConditionSingle(brand);
        System.out.println(brands);

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAddBrand() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "苹果";
        String companyName = "Apple Inc";
        int ordered = 1;
        String description = "A16";

        // 封装参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.AddBrand(brand);

        // 提交事务
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testAddBrand2() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "苹果";
        String companyName = "Apple Inc";
        int ordered = 1;
        String description = "A16";

        // 封装参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.AddBrand(brand);

        // 提交事务
        sqlSession.commit();

        System.out.println(brand.getId());
        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateBrand() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "苹果";
        String companyName = "Apple Inc";
        int ordered = 1;
        String description = "A16";
        int id = 4;

        // 封装参数
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.updateBrand(brand);

        // 提交事务
        sqlSession.commit();

        System.out.println(brand.getDescription());
        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdateBrandDynamic() throws IOException {
        // 接收参数
        int status = 1;
        String brandName = "苹果";
        String companyName = "Apple Inc";
        int ordered = 1;
        String description = "A16";
        int id = 4;

        // 封装参数
        Brand brand = new Brand();
        // brand.setStatus(status);
        // brand.setBrandName(brandName);
        // brand.setCompanyName(companyName);
        brand.setDescription(description);
        // brand.setOrdered(ordered);
        brand.setId(id);

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.updateBrandDynamic(brand);

        // 提交事务
        sqlSession.commit();

        System.out.println(brand.getDescription());
        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteById() throws IOException {
        // 接收参数
        int id = 4;

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteById(id);

        // 提交事务
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数
        int[] ids = {8, 9, 10};

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 执行方法
        brandMapper.deleteByIds(ids);

        // 提交事务
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }

    @Test
    public void testLogin() throws IOException {
        // 接收参数
        String username="zhangsan";
        String password="1243";

        // 1. 获取 SQLSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2. 获取 SQLSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取 Mapper 接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // 4. 执行方法
        User login = userMapper.Login(username, password);
        if (login == null) {
            System.out.println("登陆失败");
        }
        else System.out.println("登陆成功");

        // 提交事务
        sqlSession.commit();

        // 5. 释放资源
        sqlSession.close();
    }
}
