package com.weichuang.web;

import com.weichuang.pojo.User;
import com.weichuang.service.UserService;
import com.weichuang.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = new User();
        UserService us = new UserServiceImpl();
        try {
            //会将我们实体bean类进行自动封装，根据第二个map参数。会将map的key与实体类的成员属性进行一一映射，名字不同的映射不上。
            BeanUtils.populate(user , req.getParameterMap());
            int rows = us.registerUser(user);
            if(rows > 0){
                resp.sendRedirect(req.getContextPath() + "/login.jsp");
            }else{
                req.setAttribute("info","注册失败！");
                req.getRequestDispatcher("/register.jsp").forward(req , resp);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
