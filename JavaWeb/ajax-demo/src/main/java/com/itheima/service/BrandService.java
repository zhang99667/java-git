package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class BrandService {

    /*
     * 查询所有
     *  */

    public List<Brand> selectAll() {

        // 2.获取SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 3、获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 4.调用方法
        List<Brand> brands = mapper.selectAll();

        // 5、释放资源
        sqlSession.close();

        return brands;
    }

    public void addBrand(Brand brand){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }
}