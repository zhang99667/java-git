package com.itguigu.mpdemo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component // 表示交给 Spring 管理
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmt_create", new Date(), metaObject);
        this.setFieldValByName("gmt_modified", new Date(), metaObject);

        // 乐观锁自动填充 1
        this.setFieldValByName("version",1,metaObject);

    }

    // 使用mp实现修改操作，这个方法执行

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmt_modified", new Date(), metaObject);
    }
}
