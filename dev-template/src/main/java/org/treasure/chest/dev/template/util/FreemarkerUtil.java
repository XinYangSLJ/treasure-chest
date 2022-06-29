package org.treasure.chest.dev.template.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.swing.Java2DRenderer;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FreemarkerUtil {

    private static Configuration config = null;

    static {
        String templatePath = FreemarkerUtil.class.getResource("/").getPath() + "templates";
        try {
            templatePath = ResourceUtils.getURL("classpath:").getPath() + "templates";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        log.info("ftl路径:" + templatePath);
        config = new Configuration(Configuration.VERSION_2_3_20);
        config.setDefaultEncoding("UTF-8");
        try {
            config.setClassForTemplateLoading(FreemarkerUtil.class, "/templates");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
    }

    public static String generate(String template, Map params) throws Exception {
        Template tp = config.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        String htmlStr;
        try {
            tp.process(params, stringWriter);
            htmlStr = stringWriter.toString();
            stringWriter.flush();
        } finally {
            stringWriter.close();
        }
        return htmlStr;
    }

    private static String bufferedImageToBase64(BufferedImage bufferedImage) throws Exception {
        String png_base64;//转换成base64串
        //io流
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bufferedImage, "png", baos);//写入流中
            byte[] bytes = baos.toByteArray();//转换成字节
            png_base64 = Base64.getEncoder().encodeToString(bytes);
            png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        }
        return "data:image/jpg;base64," + png_base64;
    }

    public static String html2ImgBase64(String html, int width, int height) throws Exception {
        byte[] bytes = html.getBytes();
        BufferedImage img;
        try (ByteArrayInputStream bin = new ByteArrayInputStream(bytes)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(bin);
            Java2DRenderer renderer = new Java2DRenderer(document, width, height);
            img = renderer.getImage();
        }
        return bufferedImageToBase64(img);
    }

    public static BufferedImage html2Img(String html, int width, int height) throws Exception {
        byte[] bytes = html.getBytes();
        BufferedImage img;
        //转BufferedImage
        try (ByteArrayInputStream bin = new ByteArrayInputStream(bytes)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(bin);
            Java2DRenderer renderer = new Java2DRenderer(document, width, height);
            SharedContext sharedContext = renderer.getSharedContext();
            sharedContext.setDotsPerPixel(3);
            sharedContext.setDPI(523);
            //字体
            Font simsun = FontsUtil.getSIMSUN(Font.BOLD, 24);
            sharedContext.setFontMapping("simsun", simsun);//这样设置字体无效
            //renderer.setBufferedImageType(1);
            Map map = new HashMap<>();//设置参数
            map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            map.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            map.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            map.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            map.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            map.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            map.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            //renderer.setRenderingHints(map);
            img = renderer.getImage();
        }
        return img;
    }

}
