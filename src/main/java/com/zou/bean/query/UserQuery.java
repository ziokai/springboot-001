package com.zou.bean.query;

import java.io.Serializable;

/**
 * @author 你好
 */
public class UserQuery implements Serializable {
    /**
     * 当前页码
     */
    private Integer pageNum = 1;
    /**
     * 每一页显示的数据
     */
    private Integer pageSize = 2;
    /**
     * 查询条件
     */
    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
