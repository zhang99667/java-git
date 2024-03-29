package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookDao {
    @Select("SELECT * FROM tbl_book WHERE id = #{id}")
    public Book selectById(Integer id);
}
