package com.itheima.mapper;


import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Insert("insert into tbl_user (username, password) values (#{username},#{password})")
    void add(User user);

    @Select("select * from tbl_user")
    List<User> selectAll();

    @Select("select * from  tbl_user where id = #{id}")
    User selectById(int id);

    @Delete("delete from tbl_user where id = #{id}")
    void delete(int id);

    void update(User user);
}