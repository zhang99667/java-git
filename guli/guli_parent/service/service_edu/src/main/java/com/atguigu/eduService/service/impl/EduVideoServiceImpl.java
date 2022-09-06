package com.atguigu.eduService.service.impl;

import com.atguigu.eduService.entity.EduVideo;
import com.atguigu.eduService.mapper.EduVideoMapper;
import com.atguigu.eduService.service.EduVideoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程小结表：存储章节里面的小节信息 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {

    @Autowired
    private EduVideoService eduVideoService;

    // 根据课程 id 删除小节
    @Override
    public void removeVideoByCourseId(String courseId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        EduVideo eduVideo = eduVideoService.getOne(wrapper);
        System.out.println("[SOUT]:EduVideo -> removeVideoByCourseId" + eduVideo);
        eduVideoService.remove(wrapper);
    }
}
