package com.itguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class acl_user {
    private String id;
    private String username;
    private String password;
    private String nick_name;
    private int age;
    // gmt_create
    @TableField(fill = FieldFill.INSERT) // 创建的时候自动填充
    private Date gmt_create;

    // gmt_modified
    @TableField(fill = FieldFill.INSERT_UPDATE) // 修改的时候自动填充
    private Date gmt_modified;

    // 乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT) // 自动填充 1
    private Integer version; // 乐观锁版本号

    @TableLogic // 逻辑删除
    private int is_deleted; // 逻辑删除标志位



}
