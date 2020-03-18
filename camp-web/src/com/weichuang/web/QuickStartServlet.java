package com.weichuang.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * 生命周期；
 * init方法：是当我们servlet第一次创建时调用，仅调用一次
 * service : 每次访问servlet都会调用
 * destroy : 服务器关闭，获取servlet销毁
 */
public class QuickStartServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化方法");
        //就是servlet上下文对象
        ServletContext servletContext = servletConfig.getServletContext();
        servletContext.setAttribute("name","zhangsan");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("服务方法");
    }

    @Override
    public void destroy() {
        //servlet销毁时调用，关闭流、关闭连接
        System.out.println("销毁方法");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}
