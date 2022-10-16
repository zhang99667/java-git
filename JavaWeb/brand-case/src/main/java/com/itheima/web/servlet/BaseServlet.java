package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换 HttpServlet，根据请求的最后一段路径 进行方法奋发
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 根据资源路径进行方法分发
        // 1. 获取请求路径
        String uri = req.getRequestURI(); // uri = brand_case/brand/selectAll
        // 2. 获取最后一段路径，方法名
        int index = uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1); // 返回的结果带 '/' 故要 index + 1

        // 2.1 获取 BrandServlet 字节码对象 Class
        Class<? extends BaseServlet> cls = this.getClass();
        // 2.2 获取 Method 名称
        try {
            Method method = cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            // 2.3 执行方法
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
