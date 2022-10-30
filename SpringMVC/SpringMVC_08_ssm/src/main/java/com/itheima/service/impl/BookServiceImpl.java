package com.itheima.service.impl;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }


    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }


    public boolean delete(int id) {
        bookDao.delete(id);
        return true;
    }


    public Book selectById(int id) {
        Book book = bookDao.selectById(id);
        return book;
    }


    public List<Book> selectAll() {
        List<Book> books = bookDao.selectAll();
        return books;
    }
}