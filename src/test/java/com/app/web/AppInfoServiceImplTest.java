package com.app.web;

import com.app.web.model.SearchAppInfo;
import com.app.web.pojo.TAppInfo;
import com.app.web.service.IAppInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

/**
 * Created by huqingen on 2017/4/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class AppInfoServiceImplTest {

    @Autowired
    private IAppInfoService appInfoService;

    /**
     * 测试查询
     */
    @Test
    public void testGetAppInfo(){
        SearchAppInfo searchAppInfo = new SearchAppInfo();
        searchAppInfo.setPageIndex(0);
        searchAppInfo.setPageSize(20);
        searchAppInfo.setOs("iOS");
        searchAppInfo.setEnv("uat");
        searchAppInfo.setAppmode("release");
        appInfoService.queryAppInfo(searchAppInfo);
    }


    /**
     * 测试查询
     */
    @Test
    public void testGetLatestAppInfo(){
        SearchAppInfo searchAppInfo = new SearchAppInfo();
        searchAppInfo.setSearchAll(0);
        appInfoService.queryAppInfoForLatest(searchAppInfo);
    }


    /**
     * 测试删除
     */
    @Test
    public void testDel(){
        Long id = 2L;
        appInfoService.delAppInfo(id);

    }

    /**
     * 测试修改
     */
    @Test
    public void testModify(){
        TAppInfo appInfo = new TAppInfo();
        appInfo.setId(3L);
        appInfo.setAppmode("release");

        appInfoService.modifyAppInfo(appInfo);
    }
}



