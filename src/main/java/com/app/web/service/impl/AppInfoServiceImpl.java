package com.app.web.service.impl;

import com.app.web.api.BizMethod;
import com.app.web.dao.TAppInfoMapper;
import com.app.web.model.SearchAppInfo;
import com.app.web.pojo.TAppInfo;
import com.app.web.response.Result;
import com.app.web.service.IAppInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;

/**
 * Created by huqingen on 2017/4/1.
 */
@Service
public class AppInfoServiceImpl implements IAppInfoService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AppInfoServiceImpl.class);

    @Autowired
    private BizMethod bizMethod;

    @Autowired
    private TAppInfoMapper appInfoMapper;

    /**
     * 生成二维码地址
     * @return
     */
    public String generateQRCode(TAppInfo appInfo,Map<String,Object> requestInfo){
        String downloadUrl = appInfo.getFileUrl();
        String branchName = appInfo.getBranchName();
        String qrCodeUrl = null;
        if(branchName.contains("/")){
            branchName = branchName.replace("/","_");
        }
        String context = requestInfo.get("context").toString();
        String basePath = System.getProperty("user.dir");
        String picPath = basePath.replace(context,"") + "/imges/";
        String picName = appInfo.getOs() + "_" + branchName + "_" + appInfo.getEnv() + "_" + appInfo.getAppmode() + "_" +  appInfo.getVersion() + "_" + appInfo.getGmtCreate()+".png";
        qrCodeUrl = picPath + picName;
        File file = new File(qrCodeUrl);
        if (!file.getParentFile().exists()) {
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
            }
        }

        bizMethod.generateQRCode(downloadUrl,qrCodeUrl);

        String url = requestInfo.get("url").toString();

        String urlPath = url + "/imges/" + picName;

        return urlPath;
    }


    /**
     * 新增 app信息
     * @param appInfo
     * @return
     */
    public Result<Long> addAppInfo(TAppInfo appInfo,Map<String,Object> requestInfo){
        Result result = new Result();
        LOGGER.info("TAppInfo>>>>"+ appInfo);

        if(appInfo.getOs() == null || appInfo.getAppmode() == null || appInfo.getEnv() == null || appInfo.getBranchName() == null){
            result.setStatus(1);
            result.setMsg("缺少参数");
            return result;
        }

        if(appInfo.getGmtCreate() == null){
            appInfo.setGmtCreate(new Date().getTime());
        }
        appInfo.setQrcodeUrl(generateQRCode(appInfo,requestInfo));



        appInfoMapper.insert(appInfo);
        TAppInfo resultInfo = appInfoMapper.selectLatestRecord();
        LOGGER.info("TAppInfo>>>" + resultInfo.toString());
        if(resultInfo != null){
            result.setMsg("success");
            result.setRes(resultInfo.getId());
            return result;
        }
        result.setMsg("fail");
        result.setStatus(1);
        return result;
    }

    /**
     * 修改 app信息
     */
    public Result<Void> modifyAppInfo(TAppInfo appInfo){
        Result result = new Result();
        if(appInfo.getId() == null){
            result.setMsg("参数有误");
            result.setStatus(1);
            return result;
        }
        appInfoMapper.updateByPrimaryKeySelective(appInfo);
        result.setMsg("success");
        result.setStatus(0);
        return result;
    }

    /**
     * 删除appInfo
     * @param id
     * @return
     */
    public Result<Void> delAppInfo(Long id){
        Result result = new Result();
        TAppInfo appInfo = appInfoMapper.selectByPrimaryKey(id);
        if(appInfo == null){
            result.setMsg("数据不存在,删除失败");
            result.setStatus(1);
            return result;
        }
        appInfoMapper.deleteByPrimaryKey(id);
        result.setMsg("success");
        result.setStatus(0);
        return result;
    }

    /**
     * 查找appInfo
     * @return
     */
    public Result<List<TAppInfo>> queryAppInfo(SearchAppInfo searchAppInfo){
        Result result = new Result();
        List<TAppInfo> appInfoList = new ArrayList<TAppInfo>();

        Map<String, Object> map = new HashMap<String, Object>();
        if(searchAppInfo == null || searchAppInfo.getPageIndex() == null && searchAppInfo.getPageSize() ==null){
            map.put("pageIndex", 0);
            map.put("pageSize", 20);
            result.setMsg("查询成功");
            appInfoList = appInfoMapper.queryAppInfoListWithoutCondition(map);

            for(TAppInfo appInfo : appInfoList){
                LOGGER.info("appInfo>>>" + appInfo.toString());
            }
            result.setRes(appInfoList);
            return result;
        }

        if(searchAppInfo.getPageIndex() == null || searchAppInfo.getPageIndex() <= 0){
            map.put("pageIndex",0);
        }else {
            map.put("pageIndex", searchAppInfo.getPageIndex());
        }

        if(searchAppInfo.getPageSize() == null || searchAppInfo.getPageSize() <= 0){
            map.put("pageSize",20);
        }else {
            map.put("pageSize", searchAppInfo.getPageSize());
        }

        map.put("env",searchAppInfo.getEnv());
        map.put("os",searchAppInfo.getOs());
        map.put("branchName",searchAppInfo.getBranchName());
        map.put("mode",searchAppInfo.getAppmode());

        appInfoList = appInfoMapper.queryAppInfoListWithCondition(map);

        for(TAppInfo appInfo : appInfoList){
            LOGGER.info("appInfo>>>" + appInfo.toString());
        }

        result.setMsg("查询成功");
        result.setRes(appInfoList);

        return result;
    }


    /**
     * 查找appInfo latest
     * 根据os,env,mode,分支名称 去重后，获取最新版本的信息
     */
    public Result<List<TAppInfo>> queryAppInfoForLatest(SearchAppInfo searchAppInfo){
        Result result = new Result();
        List<TAppInfo> appInfoList = new ArrayList<TAppInfo>();

        Map<String, Object> map = new HashMap<String, Object>();
        if(searchAppInfo == null || searchAppInfo.getSearchAll() == 0){
            result.setMsg("查询成功");
            appInfoList = appInfoMapper.queryAppInfoListForLatestWithoutCondition(map);
            result.setRes(appInfoList);
            return result;
        }

        map.put("env",searchAppInfo.getEnv());
        map.put("os",searchAppInfo.getOs());
        map.put("branchName",searchAppInfo.getBranchName());
        map.put("appmode",searchAppInfo.getAppmode());

        appInfoList = appInfoMapper.queryAppInfoListForLatestWithCondition(map);

        for(TAppInfo appInfo : appInfoList){
            LOGGER.info("appInfo>>>" + appInfo.toString());
        }

        result.setMsg("查询成功");
        result.setRes(appInfoList);

        return result;
    }

}
