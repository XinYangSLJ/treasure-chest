package org.treasure.chest.dev.template.util;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author yjz
 * @Date 2021/8/10 21:42
 */
@Slf4j
public class FontsUtil {

    /**
     * 宋体
     *
     * @param style Font.BOLD
     * @param size  24
     */
    public static Font getSIMSUN(int style, float size) {
        Font font = null;
        //获取字体流
        InputStream simsunFontFile = FontsUtil.class.getResourceAsStream("/fonts/simsun.ttc");
        try {
            //创建字体
            font = Font.createFont(Font.PLAIN, simsunFontFile).deriveFont(style, size);
        } catch (FontFormatException e) {
            log.error("", e);
        } catch (IOException e) {
            font = new Font("宋体", Font.BOLD, 6);
            log.error("", e);
        }
        return font;
    }

}
