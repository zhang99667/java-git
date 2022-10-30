package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {

    @Insert("insert into tbl_book (type, name, description) VALUES (#{type},#{name},#{description})")
    public int save(Book book);

    public int update(Book book);

    @Delete("delete from tbl_book where id = #{id}")
    public int delete(int id);

    @Select("select * from tbl_book where id = #{id}")
    public Book selectById(int id);

    @Select("select * from tbl_book")
    public List<Book> selectAll();
}