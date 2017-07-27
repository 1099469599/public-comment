package com.cheng.bean;

import com.github.pagehelper.Page;

/**
 * 基础类
 * Created by cheng on 2017/7/22.
 */

public class BaseBean {

    /**
     * 分页相关参数
     */
    private Page page;

    public BaseBean() {
        this.page = new Page(1, 5);
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
