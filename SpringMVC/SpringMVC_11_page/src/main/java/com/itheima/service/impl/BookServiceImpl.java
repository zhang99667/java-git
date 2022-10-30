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
        return bookDao.save(book) > 0;
    }

    public boolean update(Book book) {
        return bookDao.update(book) > 0;
    }

    public boolean delete(int id) {
        return bookDao.delete(id) > 0;
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