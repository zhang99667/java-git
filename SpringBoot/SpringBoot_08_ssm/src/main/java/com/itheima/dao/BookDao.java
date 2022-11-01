package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    @Insert("insert into tbl_book (type, name, description) values (#{type}, #{name}, #{description});")
    public int save(Book book);

    public int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int delete(Integer id);

    @Select("select * from tbl_book where id = #{id}")
    public Book selectById(Integer id);

    @Select("select * from tbl_book;")
    public List<Book> selectAll();
}
