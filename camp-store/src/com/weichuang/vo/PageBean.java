package com.weichuang.vo;

import com.weichuang.pojo.Product;

import java.util.List;

/**
 * 分页数据的封装
 */
public class PageBean {
    private int totalPages;//最大页数
    private int currentPage;//当前页
    private int totalCount;//总数量
    private List<Product> productList;//当前页封装的数据
    private int maxCount; //前端页面中容纳的最大数量

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPages=" + totalPages +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", productList=" + productList +
                ", maxCount=" + maxCount +
                '}';
    }
}
