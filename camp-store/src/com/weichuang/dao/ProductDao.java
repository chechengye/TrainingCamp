package com.weichuang.dao;

import com.weichuang.pojo.Product;
import com.weichuang.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ProductDao {
    private QueryRunner qr;
    public ProductDao(){
        qr = new QueryRunner(C3P0Util.getDataSource());
    }
    public int getProductTotalCount() {
        String sql = "select count(*) from product";
        try {
            Long l = (Long)qr.query(sql , new ScalarHandler());
            return l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> getProductListByIndexAndMaxCount(int index, int maxCount) {
        String sql = "select p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice , p.pimage , p.pdesc from product p limit ? , ?";
        try {
            List<Product> productList = qr.query(sql, new BeanListHandler<>(Product.class), index, maxCount);
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public Product getProductByPid(String pid) {
        String sql = "select  p.pid , p.pname , p.market_price as marketPrice , p.shop_price as shopPrice , p.pimage , p.pdesc from product p where p.pid = ?";
        try {
            Product product = qr.query(sql, new BeanHandler<>(Product.class), pid);
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
