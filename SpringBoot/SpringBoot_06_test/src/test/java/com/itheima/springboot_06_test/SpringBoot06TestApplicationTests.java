package com.itheima.springboot_06_test;

import com.itheima.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot06TestApplicationTests {

	@Autowired
	private BookService bookService;

	@Test
	void contextLoads() {
		bookService.save();
	}

}