package com.itheima.service;

import com.itheima.config.SpringConfig;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class LogServiceTest extends TestCase {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAddLog() {
        accountService.transfer("Tom","Jerry",100D);
    }
}