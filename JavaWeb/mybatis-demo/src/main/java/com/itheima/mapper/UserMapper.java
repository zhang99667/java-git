package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 查询全部 User
    List<User> selectAll();

    // 根据 ID 查询用户
    User selectById(int id);

    User Login(@Param("username") String username, @Param("password") String password);

}
