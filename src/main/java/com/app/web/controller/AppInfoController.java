package com.app.web.controller;

import com.app.web.pojo.TAppInfo;
import com.app.web.request.RequestAppInfo;
import com.app.web.response.Result;
import com.app.web.model.SearchAppInfo;
import com.app.web.service.IAppInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * appInfo信息
 * Created by huqingen on 2017/4/1.
 */
@Api(value = "appInfo相关接口", description = "appInfo相关接口",produces = MediaType.ALL_VALUE)
@Controller
@RequestMapping("/")
public class AppInfoController {

    @Autowired
    private IAppInfoService appInfoService;

    /**
     * 添加 app信息
     * @param requestAppInfo
     * @return
     */
    @ApiOperation(value = "添加app信息", notes = "添加app信息")
    @RequestMapping(value = "/addAppInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result addAppInfo(@ApiParam(value = "创建AppInfo入参")@RequestBody RequestAppInfo requestAppInfo , HttpServletRequest request){

        String urlPath = request.getRequestURL().toString();
        String contextPath = request.getServletContext().getContextPath();
        String uri = request.getRequestURI();

        String resultUrl = urlPath.replace(uri,"");

        Map<String,Object> requestInfo = new HashMap<String,Object>();
        requestInfo.put("url",resultUrl);
        requestInfo.put("context",contextPath);

        TAppInfo appInfo = new TAppInfo();
        appInfo.setOs(requestAppInfo.getOs());
        appInfo.setEnv(requestAppInfo.getEnv());
        appInfo.setAppmode(requestAppInfo.getAppmode());
        appInfo.setFileUrl(requestAppInfo.getFileUrl());
        appInfo.setDes(requestAppInfo.getDes());
        appInfo.setBranchName(requestAppInfo.getBranchName());
        appInfo.setVersion(requestAppInfo.getVersion());

        return appInfoService.addAppInfo(appInfo,requestInfo);
    }


    /**
     * 查找AppInfo信息
     * @param searchAppInfo
     * @return
     */
    @ApiOperation(value = "查找App信息", notes = "查找App信息")
    @RequestMapping(value = "/getAppInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<TAppInfo>> getAppInfo(@ApiParam(value = "查找App信息入参")@RequestBody SearchAppInfo searchAppInfo){
        return appInfoService.queryAppInfo(searchAppInfo);
    }


    /**
     * 查找最新AppInfo信息
     * @param searchAppInfo
     * @return
     */
    @ApiOperation(value = "查找最新App信息", notes = "查找最新App信息")
    @RequestMapping(value = "/getLatestAppInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<List<TAppInfo>> getLatestAppInfo(@ApiParam(value = "查找App信息入参")@RequestBody SearchAppInfo searchAppInfo){
        return appInfoService.queryAppInfoForLatest(searchAppInfo);
    }


    /**
     * 删除App信息
     */
    @ApiOperation(value = "删除App信息", notes = "删除App信息")
    @RequestMapping(value = "/delAppInfo",method = RequestMethod.DELETE)
    @ResponseBody
    public Result<Void> delAppInfo(@ApiParam(value = "AppInfo编号")@RequestParam Long id){
        return appInfoService.delAppInfo(id);
    }

    /**
     * 修改App信息
     */
    @ApiOperation(value = "修改App信息", notes = "修改App信息")
    @RequestMapping(value = "/modifyAppInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result<Void> modifyAppInfo(@ApiParam(value = "AppInfo入参")@RequestBody TAppInfo appInfo){
        return appInfoService.modifyAppInfo(appInfo);
    }
}
