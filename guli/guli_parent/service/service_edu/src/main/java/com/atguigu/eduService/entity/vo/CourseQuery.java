package com.atguigu.eduService.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CourseQuery {

    @ApiModelProperty(value = "课程名称,模糊查询")
    private String title; // 课程名称

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin; // 起始时间

    @ApiModelProperty(value = "状态 'Normal' 已发布 'Draft' 未发布")
    private String status; // 状态
}