package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有品牌
     *
     * @return
     */
    @Select("SELECT * FROM tb_brand")
    @ResultMap("brandResultMap")
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
     * 分页
     *
     * @param begin 开始索引
     * @param size  每页显示条数
     * @return
     */
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总条数
     *
     * @return
     */
    int selectTotalCount();


    /**
     * 带分页的条件查询
     *
     * @param begin 开始索引
     * @param size  每页显示条数
     * @param brand 搜素条件（实体）
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     *
     * @return
     */
    int selectTotalCountByCondition(Brand brand);

    /**
     * 根据 id 删除
     *
     * @param id
     */
    @Delete("DELETE FROM tb_brand WHERE id = #{id}")
    void deleteById(int id);

    /**
     * 根据 Id 修改信息
     *
     * @param brand
     */
    void updateBrandById(Brand brand);
}