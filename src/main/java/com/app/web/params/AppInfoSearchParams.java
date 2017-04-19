package com.app.web.params;

import javax.validation.constraints.Null;

/**
 * Created by 古月随笔 on 2017/3/2.
 */
public class AppInfoSearchParams {
    @Null
    public Integer startNo;

    @Null
    public Integer pageSize;

    public Integer getStartNo() {
        return startNo;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
