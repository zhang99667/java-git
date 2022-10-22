package com.itheima;

import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForScope {
    public static void main(String[] args) {
        // 获取 IoC 容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取 bean
        BookDao bookDao1 = (BookDao) ctx.getBean("bookDao");
        BookDao bookDao2 = (BookDao) ctx.getBean("bookDao");

        System.out.println("bookDao = " + bookDao1);
        System.out.println("bookDao = " + bookDao2);
        // 可以发现，默认创建的 bookDao 是单例模式

        BookService bookService1 = (BookService) ctx.getBean("bookService");
        BookService bookService2 = (BookService) ctx.getBean("bookService");
        System.out.println("bookService1 = " + bookService1);
        System.out.println("bookService2 = " + bookService2);
    }
}