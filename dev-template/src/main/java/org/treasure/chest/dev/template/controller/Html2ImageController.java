package org.treasure.chest.dev.template.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.treasure.chest.dev.template.util.FreemarkerUtil;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/img")
@Validated
@Slf4j
public class Html2ImageController {

    /**
     * SpringBoot下载freemarker转换的图片（高清不模糊）
     * http://localhost:8080/img/test
     * <p>
     * 设置图片清晰度参数：FreemarkerUtil
     * sharedContext.setDotsPerPixel(3);
     * sharedContext.setDPI(523);
     * 解释：图片的宽度像素是确定的，通过调整dpi和dpr来调整图片清晰度
     * DPR = DPPX: 设备像素比，指CSS逻辑像素对于物理像素的倍数
     * DPI: 屏幕或纸上每英寸(2.54厘米)的点个数
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void html2ImageIo(HttpServletResponse response) throws Exception {
        Map<String, Object> param = new HashMap<>();
        param.put("name", "中文参数@123abc");
        String html = FreemarkerUtil.generate("test.ftl", param);
        BufferedImage bufferedImage = FreemarkerUtil.html2Img(html, 1500, -1);
        // 设置为png格式的文件
        response.setHeader("content-type", "image/png");
        //下载文件需要设置如下header
        //response.setHeader("content-type", "application/octet-stream");
        //response.setHeader("Content-Disposition", "attachment; filename=test.png");
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
    }


    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public void demo(HttpServletResponse response) throws Exception {
        Map map = new HashMap();
        int i = 0;
        List<UnknownError> list = new ArrayList<UnknownError>();
        while (true) {//TimeUnit.MILLISECONDS.sleep(1);

            list.add(new UnknownError());

        }
    }

}
