package com.atguigu.eduService.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.EduChapter;
import com.atguigu.eduService.entity.EduVideo;
import com.atguigu.eduService.entity.vo.ChapterVo;
import com.atguigu.eduService.service.EduChapterService;
import com.atguigu.eduService.service.EduVideoService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程章节表：存储课程章节信息 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/eduService/edu_chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;


    // 根据课程 id 进行查询
    @GetMapping("getChapterVideo/{courseId}")
    public R getChapterVideo(@PathVariable String courseId) {
        List<ChapterVo> list = eduChapterService.getChapterVideoByCourseId(courseId);
        return R.ok().data("rows", list);
    }

    // 添加章节
    @PostMapping("addChapter")
    @ApiOperation("添加章节")
    public R addChapter(@RequestBody EduChapter eduChapter) {
        eduChapterService.save(eduChapter);
        return R.ok();
    }

    // 根据章节 id 查询
    @GetMapping("getChapterInfo/{chapterId}")
    public R getChapterInfoById(@PathVariable String chapterId) {
        EduChapter eduChapter = eduChapterService.getChapterInfoById(chapterId);
        return R.ok().data("rows", eduChapter);
    }

    // 修改章节
    @PostMapping("updateChapter")
    public R updateChapter(@RequestBody EduChapter eduChapter) {
        boolean update = eduChapterService.updateById(eduChapter);
        if (!update) return R.error();
        return R.ok();
    }

    // 删除章节
    @DeleteMapping("deleteChapter/{chapterId}")
    public R deleteChapter(@PathVariable String chapterId) {
        boolean delete = eduChapterService.deleteChapter(chapterId);
        if (delete)
            return R.ok();
        else
            return R.error();
    }
}

