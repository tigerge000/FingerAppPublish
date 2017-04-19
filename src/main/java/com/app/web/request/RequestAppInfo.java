package com.app.web.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by huqingen on 2017/4/8.
 */
@ApiModel(value = "AppInfo相关参数")
public class RequestAppInfo {
    @NotNull
    @ApiModelProperty(value = "操作系统:iOS,Android,other")
    private String os;

    @NotNull
    @ApiModelProperty(value = "环境:uat,beta,live")
    private String env;

    @NotNull
    @ApiModelProperty(value = "debug,release")
    private String appmode;

    @NotNull
    @ApiModelProperty(value = "app文件下载路径")
    private String fileUrl;

    @ApiModelProperty(value = "版本")
    private Integer version;

    @NotNull
    @ApiModelProperty(value = "分支名称")
    private String branchName;

    @ApiModelProperty(value = "描述")
    private String des;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAppmode() {
        return appmode;
    }

    public void setAppmode(String appmode) {
        this.appmode = appmode;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
