package com.weichuang.service;

import com.weichuang.pojo.Product;
import com.weichuang.vo.PageBean;

public interface ProductService {
    PageBean getPageBeanByCurrentPageAndMaxCount(String currentPage, int maxCount);

    Product getProductByPid(String pid);
}
