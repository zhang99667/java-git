package com.itheima.pojo;

import lombok.Data;

import java.util.List;
@Data
// 分页查询的 JavaBean
public class PageBean<T> {
    // 总记录数
    private int totalCount;
    // 当前页数据
    private List<T> rows;
}