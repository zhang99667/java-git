package com.atguigu.service.impl;

import com.atguigu.service.ossService;
import com.atguigu.utils.ConstantPropertiesUtils;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class ossServiceImpl implements ossService {
    // 上传文件到oss
    @Override
    public String uploadFile(MultipartFile file, Integer form) {

        // 测试域名
        String QINIU_IMAGE_DOMAIN = ConstantPropertiesUtils.QINIU_IMAGE_DOMAIN;

        // 构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huabei());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = ConstantPropertiesUtils.ACCESS_KEY;
        String secretKey = ConstantPropertiesUtils.SECRET_KEY;
        String bucket = ConstantPropertiesUtils.BUCKET;
        // 利用joda写日期
        String datePath = new DateTime().toString("yyyy-MM-dd");
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        // 随机文件名
        String key;
        if (form == 1)
            key = "gui/avatar/" + datePath + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
        else if (form == 2)
            key = "gui/cover/" + datePath + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
        else
            key = "gui/other/" + datePath + "/" + UUID.randomUUID().toString() + file.getOriginalFilename();
        // 如果是Windows情况下，格式是 D:\\qiniu\\test.png
        // System.out.println(file.transferTo(););
        // String localFilePath = "C:\\Users\\a1097\\Desktop\\1.png";


        // 获取上传文件的输入流
        try {
            InputStream inputStream = file.getInputStream();

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);

            try {
                Response response = uploadManager.put(inputStream, key, upToken, null, null);
                // 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(QINIU_IMAGE_DOMAIN + "/" + key);
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    // ignore
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "http://" + QINIU_IMAGE_DOMAIN + "/" + key;
    }
}
