package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBrandServlet")
public class addBrandServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取数据，request.getParameter 不能接收 JSON 数据
        // String companyName = request.getParameter("companyName");
        // String brandName = request.getParameter("brandName");
        // String ordered = request.getParameter("ordered");
        // String description = request.getParameter("description");
        // String status = request.getParameter("status");

        // 获取请求体
        BufferedReader bufferedReader = request.getReader();
        String params = bufferedReader.readLine();

        System.out.println("params = " + params);
        // 将 JSON 字符串转换为 Java 对象
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println("brand = " + brand);
        brandService.addBrand(brand);
        // response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
