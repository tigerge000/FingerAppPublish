package com.app.web.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AppInfo入参")
public class TAppInfo {

    private Long id;
    @ApiModelProperty(value = "操作系统,iOS,Android,other")
    private String os;

    @ApiModelProperty(value = "环境,uat,beta,live")
    private String env;

    @ApiModelProperty(value = "debug,release")
    private String appmode;

    @ApiModelProperty(value = "版本")
    private Integer version;

    @ApiModelProperty(value = "分支名称")
    private String branchName;

    @ApiModelProperty(value = "描述")
    private String des;

    @ApiModelProperty(value = "创建时间")
    private Long gmtCreate;

    @ApiModelProperty(value = "不用填写")
    private String qrcodeUrl;

    @ApiModelProperty(value = "文件存放路径")
    private String fileUrl;

    @Override
    public String toString() {
        return "TAppInfo{" +
                "id=" + id +
                ", os='" + os + '\'' +
                ", env='" + env + '\'' +
                ", mode='" + appmode + '\'' +
                ", version=" + version +
                ", branchName='" + branchName + '\'' +
                ", des='" + des + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", qrcodeUrl='" + qrcodeUrl + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                '}';
    }

    public TAppInfo(Long id, String os, String env, String appmode, Integer version, String branchName, String des, Long gmtCreate, String qrcodeUrl, String fileUrl) {
        this.id = id;
        this.os = os;
        this.env = env;
        this.appmode = appmode;
        this.version = version;
        this.branchName = branchName;
        this.des = des;
        this.gmtCreate = gmtCreate;
        this.qrcodeUrl = qrcodeUrl;
        this.fileUrl = fileUrl;
    }

    public TAppInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env == null ? null : env.trim();
    }

    public String getAppmode() {
        return appmode;
    }

    public void setAppmode(String appmode) {
        this.appmode = appmode == null ? null : appmode.trim();
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
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl == null ? null : qrcodeUrl.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }
}