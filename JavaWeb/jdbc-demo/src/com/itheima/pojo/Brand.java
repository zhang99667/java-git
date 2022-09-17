package com.itheima.pojo;

import lombok.Data;

@Data
public class Brand {
    // id主键
    private int id;
    //  品牌名称
    private String brandName;
    // 企业名称
    private String companyName;
    // 排序
    private int ordered;
    // 描述信息
    private String description;
    // 状态：0: 禁用1：启用
    private int status = 0;
}
