package com.atguigu.eduService.service.impl;

import com.atguigu.eduService.entity.EduCourseDescription;
import com.atguigu.eduService.mapper.EduCourseDescriptionMapper;
import com.atguigu.eduService.service.EduCourseDescriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程简介表：存储课程简介信息 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@Service
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription> implements EduCourseDescriptionService {

    // 根据课程 ID 删除课程描述
    @Override
    public void removeDescriptionByCourseId(String courseId) {
        baseMapper.deleteById(courseId);
    }
}
