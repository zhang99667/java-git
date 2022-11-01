package com.itheima.springboot_07_mybatis;

import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot07MybatisApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelectById() {
        Book book = bookDao.selectById(1);
        System.out.println("book = " + book);
    }
}