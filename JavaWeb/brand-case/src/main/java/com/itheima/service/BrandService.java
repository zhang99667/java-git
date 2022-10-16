package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加品牌
     *
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页显示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 带条件的分页查询
     *
     * @param currentPage 当前页码
     * @param pageSize    每页显示条数
     * @param brand       查询条件（实体）
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);

    /**
     * 根据 Id 删除信息
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据 Id 更新信息
     *
     * @param brand
     */
    void updateBrandById(Brand brand);
}
