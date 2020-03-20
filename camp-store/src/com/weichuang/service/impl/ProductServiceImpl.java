package com.weichuang.service.impl;

import com.weichuang.dao.ProductDao;
import com.weichuang.pojo.Product;
import com.weichuang.service.ProductService;
import com.weichuang.vo.PageBean;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    public ProductServiceImpl(){
        productDao = new ProductDao();
    }
    /**
     * 封装pageBean给jsp页面使用
     * @param currentPage
     * @param maxCount
     * @return
     */
    @Override
    public PageBean getPageBeanByCurrentPageAndMaxCount(String currentPage, int maxCount) {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(Integer.valueOf(currentPage));
        pageBean.setMaxCount(maxCount);//12
        int totalCount = productDao.getProductTotalCount();
        pageBean.setTotalCount(totalCount);
        //20 6
        pageBean.setTotalPages((int)Math.ceil(totalCount * 1.0 / maxCount));
        //limit 0 12  index maxCount
        int index = (Integer.valueOf(currentPage) - 1) * maxCount;
        pageBean.setProductList(productDao.getProductListByIndexAndMaxCount(index , maxCount));
        return pageBean;
    }

    /**
     * 根据id获取商品
     * @param pid
     * @return
     */
    @Override
    public Product getProductByPid(String pid) {
        return productDao.getProductByPid(pid);
    }
}
