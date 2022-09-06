package com.atguigu.eduService.mapper;

import com.atguigu.eduService.entity.EduCourse;
import com.atguigu.eduService.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程表：存储课程基本信息 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getPublishCourseInfo(String courseId);
}
