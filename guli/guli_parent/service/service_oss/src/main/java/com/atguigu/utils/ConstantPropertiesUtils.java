package com.atguigu.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 交给 Sping 管理
// 当项目启动，Spring 加载后会执行接口中的方法
@Component
public class ConstantPropertiesUtils implements InitializingBean {
    // 读取配置文件内容
    @Value("${qiniu.oss.accessKey}")
    private String accessKey;

    @Value("${qiniu.oss.secretKey}")
    private String secretKey;

    @Value("${qiniu.oss.bucket}")
    private String bucket;

    @Value("${qiqiu.oss.imageDomain}")
    private String imageDomain;

    // 定义公开静态常量
    public static String ACCESS_KEY;
    public static String SECRET_KEY;
    public static String BUCKET;

    public static String QINIU_IMAGE_DOMAIN;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY = accessKey;
        SECRET_KEY = secretKey;
        BUCKET = bucket;
        QINIU_IMAGE_DOMAIN = imageDomain;
    }
}
