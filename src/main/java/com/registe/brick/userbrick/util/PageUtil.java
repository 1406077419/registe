package com.registe.brick.userbrick.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public class PageUtil {

    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PageUtil(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public static Page getPage(PageUtil pageUtil, Example example, Mapper mapper) {
        return PageHelper.startPage(pageUtil.getPageNum(), pageUtil.getPageSize()).doSelectPage(() -> mapper.selectByExample(example));
    }
}
