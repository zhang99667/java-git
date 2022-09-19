package com.itheima.test;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Log4jTest {

    private static final Logger logger = Logger.getLogger(Log4jTest.class);
    @Test
    public void Log4jOutputTest(){
        logger.debug(" This is debug!!!");
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.fatal(" This is fatal!!!");
    }
}
