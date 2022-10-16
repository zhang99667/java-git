package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    List<Brand> selectAll();

    void addBrand(Brand brand);
}