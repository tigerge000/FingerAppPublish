package com.app.web.dao;

import com.app.web.pojo.TAppInfo;

import java.util.List;
import java.util.Map;

public interface TAppInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TAppInfo record);

    int insertSelective(TAppInfo record);

    TAppInfo selectByPrimaryKey(Long id);

    //查找最新记录
    TAppInfo selectLatestRecord();

    int updateByPrimaryKeySelective(TAppInfo record);

    int updateByPrimaryKey(TAppInfo record);

    //无条件查询, 获取os,env,mode,branchname 重复及未重复时，唯一的sql记录
    List<TAppInfo> queryAppInfoListForLatestWithoutCondition(Map<String, Object> queryMap);

    //条件查询，获取os,env,mode,branchname 重复及未重复时，唯一的sql记录
    List<TAppInfo> queryAppInfoListForLatestWithCondition(Map<String, Object> queryMap);

    //分页查询AppInfo列表
    List<TAppInfo> queryAppInfoListWithoutCondition(Map<String, Object> queryMap);

    //分页查询appInfo列表
    List<TAppInfo> queryAppInfoListWithCondition(Map<String, Object> queryMap);


}