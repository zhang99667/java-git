package com.atguigu.service;

import org.springframework.web.multipart.MultipartFile;

public interface ossService {    // 上传头像到oss
    String uploadFile(MultipartFile file, Integer form);
}
