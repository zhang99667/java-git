package com.atguigu.controller;

import com.atguigu.commonUtils.R;
import com.atguigu.service.ossService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduOss")
@CrossOrigin
public class ossController {

    @Autowired
    private ossService ossService;

    @ApiOperation(value = "上传头像")
    // 上传头像的方法
    @PostMapping("uploadAvatar")
    public R uploadOssFile(MultipartFile file) {
        // 获取上传对象 MutipartFile
        // 返回上传oss的路径
        String url = ossService.uploadFile(file, 1);
        return R.ok().data("url", url);
    }

    // 上传课程封面的方法
    @PostMapping("uploadCover")
    public R uploadCoverToOss(MultipartFile file) {
        // 获取上传对象 MutipartFile
        // 返回上传oss的路径
        String url = ossService.uploadFile(file, 2);
        return R.ok().data("url", url);
    }
}
