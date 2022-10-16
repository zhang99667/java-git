package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();

    /**
     * 查询所有
     *
     * @param req
     * @param resp
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 调用 service 查询
        List<Brand> brands = brandService.selectAll();
        // 2. 转为 JSON
        String jsonString = JSON.toJSONString(brands);
        // 3. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    /**
     * 添加品牌
     *
     * @param req
     * @param resp
     */
    public void addBrand(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 接收品牌参数
        BufferedReader reader = req.getReader();
        String params = reader.readLine();

        // 2. 转换为 Brand 对象
        Brand brand = JSON.parseObject(params, Brand.class);

        // 3. 调用 service 添加
        brandService.addBrand(brand);
        // 3. 写数据
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 接收数据
        BufferedReader reader = req.getReader();
        String params = reader.readLine();
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.deleteByIds(ids);
        // 响应标识
        resp.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1. 接收当前页码和每页显示条数 url?currentPage=1&pageSize=5
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));

        // 2. 调用 Service 查询
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        // 3. 转换为 JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        // 4. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        // 获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();// json字符串
        System.out.println("params = " + params);
        // 转为 Brand
        Brand brand = JSON.parseObject(params, Brand.class);
        brand.setBrandName("%" + brand.getBrandName() + "%");
        brand.setCompanyName("%" + brand.getCompanyName() + "%");
        // 2. 调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        System.out.println("【pageBean】 = " + pageBean);
        // 2. 转为JSON
        String jsonString = JSON.toJSONString(pageBean);
        // 3. 写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        brandService.deleteById(id);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }

    public void updateBrandById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        String param = reader.readLine();
        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.updateBrandById(brand);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }
}