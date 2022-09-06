package com.atguigu.eduService.service.impl;

import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.EduCourse;
import com.atguigu.eduService.entity.EduCourseDescription;
import com.atguigu.eduService.entity.EduVideo;
import com.atguigu.eduService.entity.vo.CourseInfoVo;
import com.atguigu.eduService.entity.vo.CoursePublishVo;
import com.atguigu.eduService.mapper.EduCourseMapper;
import com.atguigu.eduService.service.EduChapterService;
import com.atguigu.eduService.service.EduCourseDescriptionService;
import com.atguigu.eduService.service.EduCourseService;
import com.atguigu.eduService.service.EduVideoService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 课程表：存储课程基本信息 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    // 章节
    @Autowired
    private EduCourseService eduCourseService;
    // 描述
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    // 章节
    @Autowired
    private EduChapterService eduChapterService;
    // 小节
    @Autowired
    private EduVideoService eduVideoService;


    // 添加课程基本信息的方法
    @Override
    public String saveCourseInfoVo(CourseInfoVo courseInfoVo) {
        // 1 向课程表添加课程基本信息
        // 将CourseInfoVo 对象转换为 eduCourse 对象
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);
        boolean saveFlag = eduCourseService.save(eduCourse);
        // 课程添加失败
        if (!saveFlag)
            throw new GuliException(20001, "课程添加失败");

        // 因为课程简介表和课程表之间为一对一关系
        // 所以需要获取课程表 ID 作为，简介表中的 ID
        String cid = eduCourse.getId();

        // 2 向课程表中添加课程简介
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVo.getDescription());
        eduCourseDescription.setId(cid);
        eduCourseDescriptionService.save(eduCourseDescription);
        return cid;
    }

    // 根据课程 id 查询课程基本信息
    @Override
    public CourseInfoVo getCourseInfo(String courseId) {
        // 1 查询课程表
        EduCourse eduCourse = eduCourseService.getById(courseId);
/*         if (eduCourse == null) {
            throw new GuliException(20001, "ERROR(eduCourseService):查询结果为空！当前ID不存在！");
        } */

        // 2 查询课程描述表
        EduCourseDescription eduCourseDescription = eduCourseDescriptionService.getById(courseId);
/*         if (eduCourseDescription == null) {
            throw new GuliException(20001, "ERROR(eduCourseDescription):查询结果为空！当前ID不存在！");
        } */

        // 3 封装
        CourseInfoVo courseInfoVo = new CourseInfoVo();
        BeanUtils.copyProperties(eduCourse, courseInfoVo);
        BeanUtils.copyProperties(eduCourseDescription, courseInfoVo);
        // 4 return
        return courseInfoVo;
    }

    // 修改课程基本信息
    @Override
    public void updateCourseInfo(CourseInfoVo courseInfoVo) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo, eduCourse);

        boolean update = eduCourseService.updateById(eduCourse);
        // 如果更新失败
        if (update == false) {
            throw new GuliException(20001, "修改课程信息失败");
        }
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setId(courseInfoVo.getId()); // 设置 id
        eduCourseDescription.setDescription(courseInfoVo.getDescription()); // 设置描述
        eduCourseDescriptionService.updateById(eduCourseDescription);
    }

    // 根据课程 id 获取课程确认信息
    @Override
    public CoursePublishVo getPublishCourseInfo(String id) {
        // 调动 mapper
        CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
        return publishCourseInfo;
    }

    // 删除课程信息
    @Override
    public void removeCourse(String courseId) {
        // 1 根据课程 id 删除小节
        eduVideoService.removeVideoByCourseId(courseId);
        // 2 根据课程 id 删除章节
        eduChapterService.removeChapterByCourseId(courseId);
        // 3 根据课程 id 删除课程描述
        eduCourseDescriptionService.removeDescriptionByCourseId(courseId);
        // 4 根据课程 id 删除课程本身
        boolean deleteCourse = eduCourseService.removeById(courseId);
        if (!deleteCourse)
            throw new GuliException(20001, "删除失败");
    }
}