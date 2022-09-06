package com.atguigu.eduService.service;

import com.atguigu.eduService.entity.EduCourseDescription;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程简介表：存储课程简介信息 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduCourseDescriptionService extends IService<EduCourseDescription> {

    void removeDescriptionByCourseId(String courseId);
}
