package com.atguigu.eduService.service.impl;

import com.atguigu.eduService.entity.EduChapter;
import com.atguigu.eduService.entity.EduVideo;
import com.atguigu.eduService.entity.vo.ChapterVo;
import com.atguigu.eduService.entity.vo.VideoVo;
import com.atguigu.eduService.mapper.EduChapterMapper;
import com.atguigu.eduService.service.EduChapterService;
import com.atguigu.eduService.service.EduVideoService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程章节表：存储课程章节信息 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduChapterService eduChapterService;
    @Autowired
    private EduVideoService eduVideoService;

    @Override
    public List<ChapterVo> getChapterVideoByCourseId(String courseId) {

        // 1 根据课程 id 查询出课程里面所有的章节
        QueryWrapper<EduChapter> wrapperChapter = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<EduChapter> eduChapterList = eduChapterService.list(wrapperChapter);

        // 2 查询小节
        QueryWrapper<EduVideo> wrapperVideo = new QueryWrapper<>();
        wrapperChapter.eq("course_id", courseId);
        List<EduVideo> eduVideoList = eduVideoService.list(wrapperVideo);

        // 3 遍历查询章节 list 集合进行封装
        List<ChapterVo> finallList = new ArrayList<>();
        for (int i = 0; i < eduChapterList.size(); i++) {
            // 每个章节
            EduChapter eduChapter = eduChapterList.get(i);
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(eduChapter, chapterVo);

            // 章节的 id，如果章节 id 对应上说明一样
            String cid = chapterVo.getId();

            List<VideoVo> videoList = new ArrayList<>();
            // 4 遍历查询小结 list 集合，进行封装
            for (int j = 0; j < eduVideoList.size(); j++) {
                EduVideo eduVideo = eduVideoList.get(j);
                // 判断小结里面的 chapterID 是不是和 章节里面的 courseID 一样
                if (eduVideo.getChapterId().equals(cid)) {
                    // 进行封装
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(eduVideo, videoVo);
                    // 放到小结封装结合
                    videoList.add(videoVo);
                }
            }
            // 把 videoList 添加到章节里
            chapterVo.setChildren(videoList);
            // 添加到 finalList 列表
            finallList.add(chapterVo);
        }
        return finallList;
    }

    // 根据章节 id 查询
    @Override
    public EduChapter getChapterInfoById(String chapterId) {
        return eduChapterService.getById(chapterId);
    }

    // 删除章节
    @Override
    public boolean deleteChapter(String chapterId) {
        // 查询 video 表，根据 chapterId 查询小结表，如果有数据，则不删除
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id", chapterId);
        int count = eduVideoService.count(wrapper);
        // 如果有数据，则不删除
        if (count > 0)
            throw new GuliException(20001, "不能删除");
        else {
            // 无数据，删除
            return eduChapterService.removeById(chapterId);
        }
    }

    // 根据课程 ID 删除章节
    @Override
    public void removeChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        eduChapterService.remove(wrapper);
    }
}
