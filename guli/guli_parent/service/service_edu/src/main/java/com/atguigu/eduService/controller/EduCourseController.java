package com.atguigu.eduService.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.EduCourse;
import com.atguigu.eduService.entity.vo.CourseInfoVo;
import com.atguigu.eduService.entity.vo.CoursePublishVo;
import com.atguigu.eduService.entity.vo.CourseQuery;
import com.atguigu.eduService.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程表：存储课程基本信息 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/eduService/edu_course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;

    // 添加课程基本信息的方法
    @PostMapping("addCourseInfo")
    public R addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String courseId = eduCourseService.saveCourseInfoVo(courseInfoVo);
        return R.ok().data("courseId", courseId);
    }

    // 根据课程 id 查询课程基本信息
    @GetMapping("getCourseInfo/{courseId}")
    @ApiOperation("根据课程 id 查询课程基本信息")
    public R getCourseInfo(@ApiParam(name = "courseId", value = "课程ID") @PathVariable String courseId) {
        CourseInfoVo courseVo = eduCourseService.getCourseInfo(courseId);
        return R.ok().data("rows", courseVo);
    }

    // 修改课程基本信息
    @PostMapping("updateCourseInfo")
    @ApiOperation("修改课程基本信息")
    public R updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        System.out.println("[SOUT] courseInfoVo" + courseInfoVo);
        eduCourseService.updateCourseInfo(courseInfoVo);
        return R.ok();
    }

    // 根据课程 id 获取课程确认信息
    @GetMapping("getPublishCourseInfo/{id}")
    public R getPublishCourseInfo(@PathVariable String id) {
        CoursePublishVo coursePublishVo = eduCourseService.getPublishCourseInfo(id);
        return R.ok().data("rows", coursePublishVo);
    }

    // 课程最终发布
    // 修改课程状态
    @PostMapping("publishCourse/{id}")
    public R publishCourse(@PathVariable String id) {
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }

    // 分页查询课程
    @GetMapping("getCoursePageList/{current}/{limit}")
    @ApiOperation("分页查询课程")
    public R getCoursePageList(@ApiParam(name = "current", value = "当前页") @PathVariable int current,
                               @ApiParam(name = "limit", value = "每页个数") @PathVariable int limit) {
        // 创建Page对象
        Page<EduCourse> pageCourse = new Page<>(current, limit); // 每页记录三个

        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        // 按时间排序
        wrapper.orderByDesc("gmt_create");
        // 调用方法实现分页
        // 调用方法的时候，底层封装，把分页所有数据封装到 pageCourse
        eduCourseService.page(pageCourse, wrapper);

        long total = pageCourse.getTotal(); // 总记录数
        List<EduCourse> records = pageCourse.getRecords(); // 数据list集合

        Map map = new HashMap<>(); // 创建一个 Map 结构存放数据
        map.put("total", total);
        map.put("rows", records);

        return R.ok().data(map);
    }


    // 4 带分页的多条件组合查询
    @ApiOperation("带分页的多条件组合查询课程列表")
    @PostMapping("pageCourseCondition/{current}/{limit}")
    public R pageCourseCondition(@PathVariable int current, @PathVariable int limit, @RequestBody(required = false) CourseQuery courseQuery) {
        // RequestBody 通过 json 传数据、ResponseBody 返回 json 数据
        System.out.println("[SOUT]:" + courseQuery);

        // 创建 page 对象
        Page<EduCourse> pageCourse = new Page<>(current, limit);
        // 创建 wrapper 对象 - 构建条件
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();

        // 多条件组合查询，设置 wrapper
        // mybatis 动态 sql
        String title = courseQuery.getTitle();
        String status = courseQuery.getStatus();
        String begin = courseQuery.getBegin();

        // 根据条件值判断
        // 判断条件值是否为空，如果不为空则拼接条件
        if (!ObjectUtils.isEmpty(title)) {
            // 构建条件
            wrapper.like("title", title);
        }
        if (!ObjectUtils.isEmpty(status)) {
            // 构建条件
            wrapper.eq("status", status);
        }
        if (!ObjectUtils.isEmpty(begin)) {
            // 时间大于 begin
            wrapper.ge("gmt_create", begin);
        }

        // 排序
        wrapper.orderByDesc("gmt_create");

        // 调用方法实现条件查询
        eduCourseService.page(pageCourse, wrapper);

        long total = pageCourse.getTotal(); // 获取总记录数
        List<EduCourse> records = pageCourse.getRecords();
        Map map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

    @ApiOperation("删除课程")
    @DeleteMapping("deleteCourse/{courseId}")
    public R deleteCourse(@PathVariable String courseId) {
        eduCourseService.removeCourse(courseId);
        return R.ok();
    }
}