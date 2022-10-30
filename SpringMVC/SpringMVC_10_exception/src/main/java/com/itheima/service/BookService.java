package com.itheima.service;

import com.itheima.domain.Book;

import java.util.List;

public interface BookService {

    public boolean save(Book book);

    public boolean update(Book book);

    public boolean delete(int id);

    public Book selectById(int id);

    public List<Book> selectAll();
}