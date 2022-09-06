package com.atguigu.eduService.service;

import com.atguigu.eduService.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程小结表：存储章节里面的小节信息 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCourseId(String courseId);
}
