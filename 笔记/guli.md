[TOC]

## OSS（七牛云）

```java
@Override
public String uploadFileAvatar(MultipartFile file) {

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
    String key = "gui/avatar/" + datePath + "/" + UUID.randomUUID().toString()+file.getOriginalFilename();
    // 如果是Windows情况下，格式是 D:\\qiniu\\test.png
    // System.out.println(file.transferTo(););
    // String localFilePath = "C:\\Users\\a1097\\Desktop\\1.png";


    // 获取上传文件的输入流
    try {
        InputStream inputStream = file.getInputStream();

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(inputStream,key,upToken,null, null);
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            // System.out.println(putRet.key);
            // System.out.println(putRet.hash);
            // System.out.println(putRet);
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

    return QINIU_IMAGE_DOMAIN + "/" + key;
}
```



## 代码生成器

```java
package com.atguigu.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

public class CodeGenerator {

    @Test
    public void run() {

        // 1、创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("E:\\Java\\guli\\guli_parent\\service\\service_edu" + "/src/main/java");
        gc.setAuthor("testjava");
        gc.setOpen(true); // 生成后是否打开资源管理器
        gc.setFileOverride(false); // 重新生成时文件是否覆盖
        gc.setServiceName("%sService");    // 去掉Service接口的首字母I，不写会变成IService
        gc.setIdType(IdType.ID_WORKER_STR); // 主键策略，如果ID为Long类型用 ID_WORKER 如果是 字符串类型 用 ID_WORKER_STR
        gc.setDateType(DateType.ONLY_DATE);// 定义生成的实体类中日期类型
        gc.setSwagger2(true);// 开启Swagger2模式

        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/guli?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置 com.atguigu.eduService
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.atguigu");
        pc.setModuleName("eduService"); // 模块名

        // 包 com.atguigu.eduService.controller
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("edu_subject"); // 根据 '表' 生成代码，根据哪个表就写哪个，可以多张表加逗号

        strategy.setNaming(NamingStrategy.underline_to_camel);// 数据库表映射到实体的命名策略
        strategy.setTablePrefix(pc.getModuleName() + "_"); // 生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作

        strategy.setRestControllerStyle(true); // restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); // url中驼峰转连字符

        mpg.setStrategy(strategy);


        // 6、执行
        mpg.execute();
    }
}
```



## 读取 `application.properties` 配置文件中的值 使用 `@Value` 注解

```
@Value("${qiniu.oss.accessKey}")
```



## joda - time 格式化的日期

[joda-time 使用详解]([(4条消息) joda-time 使用详解_梁云亮的博客-CSDN博客_joda-time](https://blog.csdn.net/lianghecai52171314/article/details/115597643))

```xml
<dependency>
    <groupId>joda-time</groupId>
    <artifactId>joda-time</artifactId>
    <version>2.10.1</version>
</dependency>
```

```java
// 利用 joda 写日期
String datePath = new DateTime().toString("yyyy-MM-dd");
```



## NGINX

- 动静分离：Java 代码 和 普通资源 分开
- 负载均衡
- 请求转发：根据请求转发到具体服务器中

#### NGINX 配置文件 nginx.conf

```properties
#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;

    server {
        listen       80;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;

		# 修改的地方 
		
        location ~ /eduService/ {
            proxy_pass http://localhost:8080;
        }

        location ~ /eduOss/ {
            proxy_pass http://localhost:8081;
        }



        # location / {
        #     root   html;
        #     index  index.html index.htm;
        # }

        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}
```



## EasyExcel

```xml
<!--EasyExcel-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
    <version>3.1.0</version>
</dependency>
```

#### 实体类

```java
// 设置 Excel 表头
@ExcelProperty(value = "学生编号",index = 0)
private Integer sno;

@ExcelProperty(value = "学生姓名",index = 1)
private String sname;
```

#### 写 - 固定路径

```java
public class writeExcel {
    public static void main(String[] args) {
        // 实现 Excel 写操作
        // 1 设置写入的文件夹地址和 Excel 文件的名称
        String fileName = "E:\\Java\\test.xlsx";
        // 2 调用 easyExcel 里面的方法实现写操作
        // write 方法有两个参数，第一个参数时文件路径名称，第二个参数是实体类class
        EasyExcel.write(fileName, DemoData.class).sheet("学生列表").doWrite(getData());
    }

    // 创建方法返回 list 集合
    private static List<DemoData> getData() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSname("lucy" + i);
            data.setSno(i);
            list.add(data);
        }
        return list;
    }
}
```

#### 读 - 固定路径

```java
public class readExcel {
    public static void main(String[] args) {
        // 文件路径和名称
        String fileName = "E:\\Java\\test.xlsx";

        // 读操作
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }
}
```

#### 读 - 文件上传

ExcelListener 不能交由 Spring 进行管理，所以无法直接操作数据库。代码如下：

##### Entity

```java
package com.atguigu.eduService.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author testjava
 * @since 2022-07-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "EduSubject对象", description = "课程科目")
public class EduSubject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程类别ID")
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "类别名称")
    private String title;

    @ApiModelProperty(value = "父ID")
    private String parentId;

    @ApiModelProperty(value = "排序字段")
    private Integer sort;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
}
```

##### Controller

```java
@RestController
@RequestMapping("/eduService/edu_subject")
public class EduSubjectController {
    // 注入 service
    @Autowired
    private EduSubjectService subjectService;

    // 添加课程分类
    // 获取上传过来的文件，把文件内容读取出来
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){
        // 上传过来的 Excel 文件
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }
}
```

##### Service

```java
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file,EduSubjectService eduSubjectService);
}
```

##### ServiceImpl

```java
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener()).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
```

##### ExcelListener

```java
package com.atguigu.eduService.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduService.entity.EduSubject;
import com.atguigu.eduService.entity.Excel.SubjectData;
import com.atguigu.eduService.service.EduSubjectService;
import com.atguigu.serviceBase.exceptionHandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    // 因为 SubjectExcelListener 不能交给 spring 进行管理，需要自己 new ，不能注入其他对象
    // 不能实现数据库操作

    public EduSubjectService eduSubjectService;

    // 有参构造
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    // 无参构造
    public SubjectExcelListener() {
    }

    // 一行一行读
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        // 判空
        if (subjectData == null)
            throw new GuliException(20001, "文件数据为空");

        // 一行一行读取，每次读取有两个值，第一个值一级分类，第二个值二级分类
        // 添加一级分类
        // 判断一级分类是否重复
        EduSubject existOneSubject = this.existOneSubject(subjectData.getOneSubjectName(), eduSubjectService);
        if (existOneSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName()); // 一级分类名称
            existOneSubject.setSort(subjectData.getThreeSubjectSort()); // 排序字段
            eduSubjectService.save(existOneSubject); // 添加到数据库
        }

        // 获取一级分类中的 id 作为 pid
        String pid = existOneSubject.getId();

        // 添加二级分类
        // 判断二级分类是否重复
        EduSubject existTwoSubject = this.existTwoSubject(subjectData.getTwoSubjectName(), pid, eduSubjectService);
        if (existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName()); // 二级分类名称
            existOneSubject.setSort(subjectData.getThreeSubjectSort()); // 排序字段
            eduSubjectService.save(existTwoSubject); // 添加到数据库
        }
    }

    // 判断一级分类不能重复添加
    private EduSubject existOneSubject(String name, EduSubjectService eduSubjectService) {
        // 检验是否数据库中已存在科目
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        return eduSubjectService.getOne(wrapper);
    }

    // 判断二级分类不能重复添加
    private EduSubject existTwoSubject(String name, String pid, EduSubjectService eduSubjectService) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", pid);
        return eduSubjectService.getOne(wrapper);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
```

## 通过构建实体表示属性之间关系

##### OneSubject.java

```java
package com.atguigu.eduService.entity.subject;

import java.util.ArrayList;
import java.util.List;

// 一级分类
public class OneSubject {
    private String id;
    private String title;
    
    // 一个一级分类有多个二级分类
    private List<TwoSubject> children = new ArrayList<>();
}
```

##### TwoSubject.java

```java
package com.atguigu.eduService.entity.subject;

import lombok.Data;

// 二级分类
@Data
public class TwoSubject {
    private String id;
    private String title;
}
```

##### Controller

```java
// 获取课程列表
@ApiOperation("获取课程列表")
@GetMapping("getSubject")
public R getSubject(){
    List<OneSubject> subjectList = subjectService.getAllOneTwoSubject();
    return R.ok().data("rows",subjectList);
}
```

##### Service

```java
List<OneSubject> getAllOneTwoSubject();
```

##### ServiceImpl

```java
@Override
public List<OneSubject> getAllOneTwoSubject() {
    QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
    // 查询所有一级分类
    wrapperOne.eq("parent_id", "0");
    // List<EduSubject> one = baseMapper.selectList(wrapperOne);
    List<EduSubject> oneEduSubjectList = subjectService.list(wrapperOne);

    // 查询所有二级分类
    QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
    wrapperTwo.ne("parent_id", "0");
    List<EduSubject> twoEduSubjectList = subjectService.list(wrapperTwo);
    // 创建 list 集合，用于存储最终封装的数据
    List<OneSubject> finalSubjectList = new ArrayList<>();

    // 封装一级分类
    // 查询出来的所有的一级分类 list 集合遍历，得到每个一级分类对象，获取每一个一级分类对象值
    // 封装到要求的 list 集合里面 List<OneSubject> finalSubjectList
    for (int i = 0; i < oneEduSubjectList.size(); i++) {
        // 得到 oneSubjectList 中的每一个 eduSubject 对象
        EduSubject oneEduSubject = oneEduSubjectList.get(i);
        // 把 eduSubject 里面值获取出来，放到 OneSubject 对象里面
        OneSubject oneSubject = new OneSubject();

        // 多个 OneSubject 放到 finalSubjectList 里面
        // 手动实现
        // oneSubject.setId(onewEduSubject.getId());
        // oneSubject.setTitle(onewEduSubject.getTitle());
        // oneSubject.setSort(onewEduSubject.getSort());
        // 使用工具类实现上述两行代码的同样功能
        BeanUtils.copyProperties(oneEduSubject, oneSubject);

        // 添加到 list 中
        finalSubjectList.add(oneSubject);

        // 封装二级分类
        // 在一级分类循环遍历查询所以的二级分类
        // 创建 list 集合封装每一个一级分类的二级分类
        List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
        // 遍历二级分类
        for (int j = 0; j < twoEduSubjectList.size(); j++) {
            // 从 twoEduSubjectList 中获取每一个二级分类到 twoEduSubject 中
            EduSubject twoEduSubject = twoEduSubjectList.get(j);
            // 判断二级分类的 parent_id 和一级分类的 id 是否一致
            if (twoEduSubject.getParentId().equals(oneEduSubject.getId())) {
                // 创建一个 twoSubject 用于存放
                TwoSubject twoSubject = new TwoSubject();
                // 复制属性
                BeanUtils.copyProperties(twoEduSubject, twoSubject);
                // 添加至列表
                twoFinalSubjectList.add(twoSubject);
            }
        }
        // 把所有二级分类放到一级分类中
        oneSubject.setChildren(twoFinalSubjectList);
    }
    return finalSubjectList;
}
```

## ApiModelProperty 注解

用于方法，字段的说明  [@ApiModelProperty注解](https://blog.csdn.net/weixin_58276266/article/details/121851886)

```java
@ApiModelProperty(value = "课程ID")
```

## BigDecimal 用于高精度的小数表示

```java
@ApiModelProperty(value = "课程销售价格，设置为0可免费观看")
private BigDecimal price;
```

## TableField 注解

MybatisPlus 自动填充注解  [MybatisPlus中@TableField注解的使用详解](https://blog.csdn.net/qq_43842093/article/details/124956549?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-124956549-blog-84893854.pc_relevant_multi_platform_whitelistv1_exp2&spm=1001.2101.3001.4242.1&utm_relevant_index=3)

```java
@ApiModelProperty(value = "创建时间")
@TableField(fill = FieldFill.INSERT)
private Date gmtCreate;

@ApiModelProperty(value = "更新时间")
@TableField(fill = FieldFill.INSERT_UPDATE)
private Date gmtModified;
```

## TableId 注解

MybatisPlus 主键规则  [@tableid注解_MyBatis-Plus 常用注解](https://blog.csdn.net/weixin_42526068/article/details/113039510)

```java
@ApiModelProperty(value = "课程ID")
@TableId(value = "id", type = IdType.ID_WORKER_STR)
private String id;
```

## 动态路由

`this.$router.push()`

```javascript
this.$router.push({ path: "/subject/list" });
```

[this.$router.push()两种常见用法](https://blog.csdn.net/qq_42552857/article/details/118678031)

## 富文本编辑器 - Tinymce

##### 参考

[三方集成专区 | TinyMCE中文文档中文手册 (ax-z.cn)](http://tinymce.ax-z.cn/integrations/integrate-index.php)

[vue-tinymce - A simple vue-based tinymce component (gitee.io)](https://packy-tang.gitee.io/vue-tinymce/#/)

## 判断路径中是否存在 id 值

```javascript
// 判断路径是否有id值
if (this.$route.params && this.$route.params.id) {
    // 从路径获取id值
    this.courseId = this.$route.params.id;
}
```

## 连表查询

### **内连接**

内连接是从结果中 **删除** 其他被连接表中 **没有匹配行** 的所有行，所以内连接 **可能会丢失信息**。

### 外连接

**外连接一定会提供数据行，无论还行能否在另一个表中找出相匹配的行**

[(5条消息) 内连接（inner join）与外连接(outer join)小结_蝉 沐 风的博客-CSDN博客_inner join](https://blog.csdn.net/chanmufeng/article/details/78234654)

#### 左外连接

**LEFT OUTER JOIN（左外连接）接收左表的所有行，并用这些行与右表进行匹配**
当左表与右表具有一对多的关系时，左外连接特别有用

```sql
-- 左外连接
SELECT
	ec.id,-- 课程 id
	ec.title,-- 课程名
	ec.price,-- 课程 价格
	ec.lesson_num,-- 课程 课时
	ecd.description,-- 课程 简介
	es1.title AS oneSubject,-- 一级分类
	es2.title AS twoSubject,-- 二级分类
	et.NAME AS teacherName -- 讲师姓名
	
FROM
	edu_course ec
	LEFT OUTER JOIN edu_course_description ecd ON ec.id = ecd.id
	LEFT OUTER JOIN edu_teacher et ON ec.teacher_id = et.id
	LEFT OUTER JOIN edu_subject es1 ON ec.subject_parent_id = es1.id
	LEFT OUTER JOIN edu_subject es2 ON ec.subject_id = es2.id 
WHERE
	ec.id = 18
```

#### 右外连接

与左外连接完全相同，只不过是用右表来评价左表
**此外：RIGHT OUTER JOIN左侧的表为右表！！！！！**



## 自定义 mapper

EduCourseMapper.xml

```sql
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.atguigu.eduService.mapper.EduCourseMapper">

    <!--sql 语句：根据课程 id 查询课程确认信息-->
    <!--id 写 mapper 接口中的方法-->
    <!--resultType 写类型包的路径-->
    <!--resultMap 自定义类型-->
    <select id="getPublishCourseInfo" resultType="com.atguigu.eduService.entity.vo.CoursePublishVo">
        -- 左外连接
        SELECT ec.id,-- 课程 id
               ec.title,-- 课程名
               ec.cover, -- 课程 封面
               ec.price,-- 课程 价格
               ec.lesson_num,-- 课程 课时
               ecd.description,-- 课程 简介
               es1.title AS oneSubject,-- 一级分类
               es2.title AS twoSubject,-- 二级分类
               et.NAME   AS teacherName -- 讲师姓名

        FROM edu_course ec
                 LEFT OUTER JOIN edu_course_description ecd ON ec.id = ecd.id
                 LEFT OUTER JOIN edu_teacher et ON ec.teacher_id = et.id
                 LEFT OUTER JOIN edu_subject es1 ON ec.subject_parent_id = es1.id
                 LEFT OUTER JOIN edu_subject es2 ON ec.subject_id = es2.id
        WHERE ec.id = #{courseId}
    </select>
</mapper>
```

EduCourseMapper.java

```java
package com.atguigu.eduService.mapper;

import com.atguigu.eduService.entity.EduCourse;
import com.atguigu.eduService.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 课程表：存储课程基本信息 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-07-22
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    public CoursePublishVo getPublishCourseInfo(String courseId);
}
```

EduCourseService.java

```java
CoursePublishVo getPublishCourseInfo(String id);
```

EduCourseServiceImpl.java

```java
// 根据课程 id 获取课程确认信息
@Override
public CoursePublishVo getPublishCourseInfo(String id) {
    // 调动 mapper
    CoursePublishVo publishCourseInfo = baseMapper.getPublishCourseInfo(id);
    return publishCourseInfo;
}
```

EduCourseController.java

```java
// 根据课程 id 获取课程确认信息
@GetMapping("getPublishCourseInfo/{id}")
public R getPublishCourseInfo(@PathVariable String id) {
    CoursePublishVo coursePublishVo = eduCourseService.getPublishCourseInfo(id);
    return R.ok().data("rows",coursePublishVo);
}
```



## 配置 mapeer.xml 文件的路径

application.properties

```properties
#配置 mapeer.xml 文件的路径
mybatis-plus.mapper-locations=classpath:com/atguigu/eduService/mapper/xml/*.xml
```

pom.xlm

```xml
<!--加载 xml 文件-->
<build>
    <resources>
        <resource>
            <directory>src/main/java/</directory>
            <includes>
                <!--** 代表加载深度为两层，* 代表加载深度为一层-->
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
</build>
```



## SpringBoot 返回格式化日期

application.properties

```properties
#return format json time
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8
```



## 外键

​	如果一个实体的某个字段指向另一个实体的主键，就称为外键。被指向的实体，称之为主实体（主表），也叫父实体（父表）。负责指向的实体，称之为从实体（从表），也叫子实体（子表）。

外键的作用：

- 为了一张表记录的数据不要太过 冗余。
- 保持数据的一致性、完整性。



## 逻辑删除

[SpringBoot逻辑删除_菜程序的博客-CSDN博客](https://blog.csdn.net/weixin_45032080/article/details/120172450)



## Vue - 函数默认值

```js
// current = 1 指定默认值
    getCoursePageList(current = 1) {
      // 切换当前页
      this.pagination.current = current;
      getCoursePageList(this.pagination.current, this.pagination.limit).then(
        (response) => {
          this.coursePageList = response.data.rows;
          this.pagination.total = response.data.total;
        }
      );
    },
```

