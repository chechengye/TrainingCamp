package com.weichuang.web;

import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;
import com.weichuang.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productInfo")
public class ProductInfoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        ProductService ps = new ProductServiceImpl();
        Product product = ps.getProductByPid(pid);
        if(null != product){
            req.setAttribute("product" , product);
            req.getRequestDispatcher("/product_info.jsp").forward(req , resp);
        }
    }
}
