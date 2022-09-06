package com.atguigu.eduService.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.subject.OneSubject;
import com.atguigu.eduService.service.EduSubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-19
 */
@RestController
@RequestMapping("/eduService/edu_subject")
@CrossOrigin
public class EduSubjectController {
    // 注入 service
    @Autowired
    private EduSubjectService subjectService;

    // 添加课程分类
    // 获取上传过来的文件，把文件内容读取出来
    @ApiOperation("上传课程列表 Excel 文件")
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        // 上传过来的 Excel 文件
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }


    // 获取课程列表，包含一级和二级
    @ApiOperation("获取课程列表")
    @GetMapping("getSubjectList")
    public R getSubjectList(){
        List<OneSubject> subjectList = subjectService.getAllOneTwoSubject();
        return R.ok().data("rows",subjectList);
    }
}

