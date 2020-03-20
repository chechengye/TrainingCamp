package com.weichuang.web;

import com.weichuang.service.ProductService;
import com.weichuang.service.impl.ProductServiceImpl;
import com.weichuang.vo.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //从前端会获取的数据
        int maxCount = 12;
        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        ProductService ps = new ProductServiceImpl();
        PageBean pageBean = ps.getPageBeanByCurrentPageAndMaxCount(currentPage , maxCount);
        System.out.println("pageBean = " + pageBean);
        req.setAttribute("pageBean" , pageBean);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req ,resp);
    }
}
