package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.commonUtils.R;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void ossUploadTest() {
        String QINIU_IMAGE_DOMAIN = "rf5w5qwhg.hb-bkt.clouddn.com";

        // 构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huabei());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
        String accessKey = "NlZIr5vUeuvGGIOPzIRLRJgy_acvOAWfkjUGF7in";
        String secretKey = "8yB6ktuiReXo5PI03bVoSXktgjoQIGa1tvWHNLFJ";
        String bucket = "bs-application";
        // 如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath = "C:\\Users\\a1097\\Desktop\\1.png";
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            // System.out.println(putRet.key);
            // System.out.println(putRet.hash);
            System.out.println(putRet);
            System.out.println(QINIU_IMAGE_DOMAIN + "/" + putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                // ignore
            }
        }
    }
}
