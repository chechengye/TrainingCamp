package com.weichuang.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/quickStartHttp")
public class QuickStartHttpServlet extends HttpServlet {
    /**
     * Get请求方式时，默认调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req , resp);
    }

    /**
     * Post请求方式时调用doPost
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //编写web相关代码  不需要使用new 再创建对象
        //System.out.println(this.getServletContext().getAttribute("name"));
        //重定向方法 req.getContextPath() : 获取配置路径
        //resp.sendRedirect(req.getContextPath() + "/index.jsp");
        //可以处理中文乱码问题resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //响应体写数据 resp.getWriter() : 匿名类
        PrintWriter printWriter = resp.getWriter();//获取字符流。
        printWriter.write("张三在上学"); //写入到response缓冲区中。默认编码格式为iso8859-1
        //处理请求参数中文乱码的问题
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("name") + " id = " + req.getParameter("id"));
        //request也是一个域对象
        req.setAttribute("name" , "lily");
        //内部转发，请求地址不会改变
        req.getRequestDispatcher("/index.jsp").forward(req , resp);
        //session会话域
        HttpSession session = req.getSession();
        session.setAttribute("name","tom");
        Cookie cookie = new Cookie("JSESSIONID" , session.getId());
        cookie.setMaxAge(1000*60*30);
        resp.addCookie(cookie);

    }
}
