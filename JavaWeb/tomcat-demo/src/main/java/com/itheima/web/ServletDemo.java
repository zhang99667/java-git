package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo", loadOnStartup = 1) // 启动的时候实例化，加快启动速度
public class ServletDemo implements Servlet {
    private ServletConfig config;

    /*
     * 初始化方法
     * 1. 调用时机：默认情况下，Servlet 被第一次访问时，调用
     *   * loadOnStartup：默认值 -1
     * 2. 调用次数：1 次
     * */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("...");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    /*
     * 提供服务
     * 1. 调用时机：每一次 Servlet 被访问
     * 2. 调用次数：多次
     * */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world");
    }

    public String getServletInfo() {
        return null;
    }

    /*
     * 销毁方法
     * 1. 调用时机：内存释放或服务器关闭时，Servlet 对象会销毁
     * 2. 调用次数：1 次
     *  */
    public void destroy() {
        System.out.println("被销毁");
    }
}
