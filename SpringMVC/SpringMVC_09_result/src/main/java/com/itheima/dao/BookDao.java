package com.itheima.dao;

import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {

    @Insert("INSERT INTO tbl_book (type, name, description) VALUES (#{type},#{name},#{description})")
    public void save(Book book);

    public void update(Book book);

    @Delete("DELETE FROM tbl_book WHERE id = #{id}")
    public void delete(int id);

    @Select("select * from tbl_book where id = #{id}")
    public Book selectById(int id);

    @Select("select * from tbl_book")
    public List<Book> selectAll();
}
