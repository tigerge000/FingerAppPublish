package com.app.web.api;

/**
 * Created by huqingen on 2017/4/1.
 */
public interface BizMethod {

    /**
     * 二维码生成，并写入
     * @param text URL地址
     * @param outPath 生成文件路径
     * @return
     */
    String generateQRCode(String text,String outPath);
}
