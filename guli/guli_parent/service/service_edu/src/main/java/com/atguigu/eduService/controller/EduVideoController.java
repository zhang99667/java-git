package com.atguigu.eduService.controller;


import com.atguigu.commonUtils.R;
import com.atguigu.eduService.entity.EduVideo;
import com.atguigu.eduService.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程小结表：存储章节里面的小节信息 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/eduService/edu_video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;


    // 添加小节
    @PostMapping("addVideo")
    public R addVideo(@RequestBody EduVideo eduVideo) {
        System.out.println("[SOUT]:" + eduVideo);
        boolean save = eduVideoService.save(eduVideo);
        if (save) {
            return R.ok();
        }
        return R.error();
    }

    // 删除小节
    @DeleteMapping("deleteVideo/{id}")
    public R deleteVideo(@PathVariable String id) {
        eduVideoService.removeById(id);
        return R.ok();
    }
}

