package com.atguigu.eduService.service;

import com.atguigu.eduService.entity.EduCourse;
import com.atguigu.eduService.entity.vo.CourseInfoVo;
import com.atguigu.eduService.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程表：存储课程基本信息 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfoVo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo getPublishCourseInfo(String id);

    void removeCourse(String courseId);
}
