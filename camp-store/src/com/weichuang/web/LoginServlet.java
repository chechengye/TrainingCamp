package com.weichuang.web;

import com.weichuang.pojo.User;
import com.weichuang.service.UserService;
import com.weichuang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService us = new UserServiceImpl();
        User user = us.login(username , password);
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("JSESSIONID" , session.getId());
        cookie.setMaxAge(1000 * 60 * 30);
        resp.addCookie(cookie);
        if(null != user){
            session.setAttribute("user" , user);
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }else{
            req.setAttribute("errorInfo" , "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req , resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
