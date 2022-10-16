package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    // 1. 创建 sqlSessionFactory 工厂对象
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        // 2. 获取 BrandMapper
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3. 调用方法
        List<Brand> brands = mapper.selectAll();
        // 4. 释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void addBrand(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        // 1. 获取 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 2. 获取 BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 3. 计算开始索引
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        // 4. 查询当前页数据
        List<Brand> rows = mapper.selectByPage(begin, size);
        // 5. 查询总记录数
        int totalCount = mapper.selectTotalCount();
        // 6. 封装 PageBean 对象
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        // 7. 释放资源
        sqlSession.close();
        // 8. 返回对象
        return brandPageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        // 处理 brand 条件查询的模糊表达式
        String brandName = brand.getBrandName();
        if (brandName != null && brandName.length() > 0) {
            brand.setBrandName("%" + brandName + "%");
        }

        String companyName = brand.getCompanyName();
        if (companyName != null && companyName.length() > 0) {
            brand.setBrandName("%" + companyName + "%");
        }
        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);
        int totalCountByCondition = mapper.selectTotalCountByCondition(brand);
        sqlSession.close();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCountByCondition);
        return brandPageBean;
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateBrandById(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateBrandById(brand);
        sqlSession.commit();
        sqlSession.close();
    }
}