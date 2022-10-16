package com.itheima.web.servlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/brand/*")
public class BrandServlet extends BaseServlet{
    public void selectAll(){
        System.out.println("brand selectAll...");
    }

    public void addBrand(){
        System.out.println("brand addBrand...");
    }
}
