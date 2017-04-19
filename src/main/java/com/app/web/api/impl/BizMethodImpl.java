package com.app.web.api.impl;

import com.app.web.api.BizMethod;
import com.app.web.service.impl.AppInfoServiceImpl;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基本通用方法
 * Created by huqingen on 2017/4/1.
 */
@Service
public class BizMethodImpl implements BizMethod {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppInfoServiceImpl.class);

    /**
     * 二维码生成，并写入
     */
    public String generateQRCode(String text,String outPath){
        ByteArrayOutputStream byteArrayOutputStream = QRCode.from(text).to(ImageType.PNG).stream();
        try {
            byteArrayOutputStream.writeTo(new FileOutputStream(outPath));
            return outPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
