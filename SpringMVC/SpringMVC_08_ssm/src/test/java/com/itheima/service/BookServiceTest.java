package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest extends TestCase {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookDao bookDao;

    @Test
    public void testSave() {

    }

    public void testUpdate() {
    }

    public void testDelete() {
    }

    @Test
    public void testSelectById() {
        Book book = bookService.selectById(1);
        System.out.println("book = " + book);
    }

    @Test
    public void testSelectAll() {
        List<Book> books = bookService.selectAll();
        System.out.println("books = " + books);
    }
}