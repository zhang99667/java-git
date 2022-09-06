package com.atguigu;

import static org.junit.Assert.assertTrue;

import com.atguigu.serviceBase.exceptionHandler.GuliException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class EduApplicationTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test001() {

        Map<String, String> test = new HashMap<String, String>();
        test.put("state", "SUCCESS");
        System.out.println(test);
    }

    @Test
    public void ExceptionTest(){
        try {
            int i = 10/0;
        }catch (Exception e){
            // 执行自定义异常
            throw new GuliException(20001,"执行了自定义异常，errorCode:20001");
        }
    }
}
