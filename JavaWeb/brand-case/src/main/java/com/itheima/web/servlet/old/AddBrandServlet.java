package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

// @WebServlet(urlPatterns = "/addBrandServlet")
public class AddBrandServlet extends HttpServlet {

    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收品牌参数
        BufferedReader reader = req.getReader();
        String params = reader.readLine();

        // 2. 转换为 Brand 对象
        Brand brand = JSON.parseObject(params, Brand.class);

        // 3. 调用 service 添加
        brandService.addBrand(brand);
        // 3. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
