package com.atguigu.eduService.entity.vo;

import lombok.Data;

@Data
public class CoursePublishVo {
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String oneSubject;
    private String twoSubject;
    private String teacherName;
    private String price;
}
