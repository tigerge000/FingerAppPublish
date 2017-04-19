package com.app.web.service;

import com.app.web.model.SearchAppInfo;
import com.app.web.pojo.TAppInfo;
import com.app.web.response.Result;

import java.util.List;
import java.util.Map;

/**
 * App信息处理
 * Created by huqingen on 2017/4/1.
 */
public interface IAppInfoService {

    /**
     * 新增 app信息
     * @param appInfo
     * @return
     */
    Result<Long> addAppInfo(TAppInfo appInfo, Map<String,Object> requestInfo);

    /**
     * 修改 app信息
     */
    Result<Void> modifyAppInfo(TAppInfo appInfo);

    /**
     * 删除appInfo
     * @param id
     * @return
     */
    Result<Void> delAppInfo(Long id);

    /**
     * 查找appInfo
     * @return
     */
    Result<List<TAppInfo>> queryAppInfo(SearchAppInfo searchAppInfo);

    /**
     * 查找appInfo latest
     * 根据os,env,mode,分支名称 去重后，获取最新版本的信息
     */
    Result<List<TAppInfo>> queryAppInfoForLatest(SearchAppInfo searchAppInfo);


}
