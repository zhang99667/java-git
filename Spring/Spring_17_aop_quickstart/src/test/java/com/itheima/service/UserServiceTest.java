package com.itheima.service;

import com.itheima.pojo.User;
import config.SpringConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest extends TestCase {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectById() {
        User user = userService.selectById(2);
        System.out.println(user);
    }

    @Test
    public void testSelectAll() {
        System.out.println(userService.selectAll());
    }
}