package com.app.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by huqingen on 2017/4/1.
 */
@ApiModel(value = "查找AppInfo入参")
public class SearchAppInfo {
    @ApiModelProperty(value = "页码")
    private Integer pageIndex;
    @ApiModelProperty(value = "页数")
    private Integer pageSize;
    @ApiModelProperty(value = "环境,uat,beta,live")
    private String env;
    @ApiModelProperty(value = "操作系统,iOS,Android,other")
    private String os;
    @ApiModelProperty(value = "分支名称")
    private String branchName;

    public String getAppmode() {
        return appmode;
    }

    public void setAppmode(String appmode) {
        this.appmode = appmode;
    }

    @ApiModelProperty(value = "debug,release")
    private String appmode;

    @NotNull
    @ApiModelProperty(value = "是否查询所有,0:所有,1:条件查询")
    private Integer searchAll;

    public Integer getSearchAll() {
        return searchAll;
    }

    public void setSearchAll(Integer searchAll) {
        this.searchAll = searchAll;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

}
