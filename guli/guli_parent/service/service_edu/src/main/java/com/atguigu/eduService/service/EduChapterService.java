package com.atguigu.eduService.service;

import com.atguigu.eduService.entity.EduChapter;
import com.atguigu.eduService.entity.vo.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程章节表：存储课程章节信息 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    EduChapter getChapterInfoById(String chapterId);

    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
