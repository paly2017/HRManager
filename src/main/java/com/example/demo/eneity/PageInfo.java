package com.example.demo.eneity;

import java.util.List;

/***
 * 分页
 */
public class PageInfo<T> {
    private Long pageSize;//每页显示数据条数
    private Long pageIndex;//当前页
    private Long pageStart;//查询数据其实位置
    private Long pageCount;//总页数
    private Long dataCount;//数据总条数
    private List<T> list;


    public PageInfo(Long pageSize, Long pageIndex, Long dataCount) {
        this.pageSize = pageSize<0?0L:pageSize;
        this.dataCount = dataCount;
        this.pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
        this.pageIndex = pageIndex>=this.pageCount?this.pageCount:pageIndex;
        this.pageStart = (pageIndex-1)*pageSize;
    }


    public Long getPageSize() {
        return pageSize;
    }

    public Long getPageIndex() {
        return pageIndex;
    }

    public Long getPageStart() {
        return pageStart;
    }

    public Long getPageCount() {
        return pageCount;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
