package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

public interface BookService {
    public boolean save(Book book);

    public boolean update(Book book);

    public boolean delete(Integer id);

    public Book selectById(Integer id);

    public List<Book> selectAll();
}
