package com.itheima.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 响应字符数据：设置字符数据的响应体
 *  */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 读取文件
        FileInputStream fis = new FileInputStream("E://2022-20203 第一学期/课程表.png");
        // 2. 获取 response 字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        // 3. 完成流的 copy - 一般有工具类来完成
/*         byte[] buff = new byte[1024];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            outputStream.write(buff, 0, len );
        } */
        org.apache.commons.io.IOUtils.copy(fis, outputStream);
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}