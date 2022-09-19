package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /*
     * 查询所有 */
    List<Brand> selectAll();

    /*
     * 查看详情：
     * 根据 id 查询信息
     *  */
    Brand selectById(int id);

    /*
     * 条件查询
     *  * 参数接收
     *      1. 散装参数：如果方法中有多个参数，需要使用 @Param ("SQL占位符名称")
     *      2. 对象参数：对象的属性名称要和参数占位符名称一致
     *      3. map 集合参数
     *  */
    // 1. 散装参数
    /* List<Brand> selectByCondition(@Param("brandName") String brandName,
                            @Param("companyName") String companyName,
                            @Param("status") int status); */
    // 2. 对象参数
    // List<Brand> selectByCondition(Brand brand);

    // map 集合
    List<Brand> selectByCondition(Map map);

    /*
    * 单条件动态查询
    *  */
     List<Brand> SelectByConditionSingle(Brand brand);

}
