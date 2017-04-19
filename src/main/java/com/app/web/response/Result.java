package com.app.web.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * Created by 古月随笔 on 2017-04-01
 */
@ApiModel(value = "响应结果")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result<T> implements java.io.Serializable {

    // 是否成功标识
    @ApiModelProperty(value = "是否成功标识")
    private int status = 0;

    // 消息
    @ApiModelProperty(value = "消息")
    private String msg;

    // 返回的数据
    @ApiModelProperty(value = "返回的数据")
    private T res;

    public Result() {
    }

    public Result(T res) {
        this.res = res;
    }


    @JsonIgnore
    public boolean isSuccess() {
        return status == 0 ? true : false;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRes() {
        return res;
    }

    public void setRes(T res) {
        this.res = res;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
