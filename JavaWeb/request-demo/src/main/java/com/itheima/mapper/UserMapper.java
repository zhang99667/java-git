package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    /*
     * 查找用户
     *  */
    @Select("SELECT * FROM tb_user WHERE username = #{username} and password = #{password}")
    User getUserInfo(@Param("username") String username, @Param("password") String password);

    /*
     * 查找用户名是否重复
     *  */
    @Select("SELECT * FROM tb_user WHERE username=#{username}")
    User selectByUsername(@Param("username") String username);

    /*
     * 用户注册
     *  */
    void register(@Param("username") String username, @Param("password") String password);
}
