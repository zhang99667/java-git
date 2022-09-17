package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /*
    * 查询所有 */
    List<Brand> selectAll();

    /*
    * 查看详情：
    * 根据 id 查询信息
    *  */
    Brand selectById(int id);

}
