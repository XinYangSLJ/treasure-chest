package org.treasure.chest.dev.template.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import sun.net.www.content.image.png;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author lj
 * @version 1.0.0
 * @Description 图片合成工具
 * @createTime 2023-02-15 16:58
 */
public class CompositeImageUtils {

    private CompositeImageUtils(){}


    /**
     * 图片合成
     *
     * @param baseImagePath 基础图片
     * @param imagePath 叠加图片
     */
    public static void compositeImage(String baseImagePath, String imagePath){

        try {
            File baseImageFile = new File(baseImagePath);
            BufferedImage imageBase = ImageIO.read(baseImageFile);

            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);

            Graphics graphics = imageBase.getGraphics();
//            graphics.drawImage(image, 0,0, null);
            graphics.drawImage(image, imageBase.getWidth()/2,imageBase.getHeight()/2, null);

            File outFile = new File("C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\999.png");
            ImageIO.write(imageBase, "png", outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 导入网络图片到缓冲区
     */
    public BufferedImage loadImageUrl(String imgName) {
        try {
            URL url = new URL(imgName);
            return ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     *
     * @param filePath 文件储存路径
     * @param fileName 优惠券名称
     * @param desc 描述
     * @return
     */
    public static String generateCounop(String filePath,String fileName,String desc) {
        String floorPath = "";//需要合成图片路径
        String path = createStringMark(filePath, desc, "C://image//counop"+fileName+"4.jpg");
        return "";
    }

    /**
     *
     * @param filePath 文件路径
     * @param markContent
     * @param outPath
     * @return
     */
    public static String createStringMark(String filePath, String markContent, String outPath) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image theImg = imgIcon.getImage();
        int width = theImg.getWidth(null) == -1 ? 200 : theImg.getWidth(null);
        int height = theImg.getHeight(null) == -1 ? 200 : theImg.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.setPaint(Color.WHITE);
        g.setBackground(Color.WHITE);// 设置背景色
        g.setColor(new Color(251, 212, 176));
        g.clearRect(0, 0, width, height);
        g.drawImage(theImg, 0, 0, null);
        g.setFont(new Font(null, Font.BOLD, 16)); // 字体、字型、字号
        g.drawString(markContent, 40, 60); // 在图片上写内容
        g.dispose();
        try {
            FileOutputStream out = new FileOutputStream(outPath); // 先用一个特定的输出文件名
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
            param.setQuality(100, true);
            encoder.encode(bimage, param);
            out.close();
        } catch (Exception e) {
            return e.getMessage();
        }
        return outPath;
    }


    public static void main(String[] args) {


        String logoPath = "C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\500.png";
        String basePath = "C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\124.jpg";
        CompositeImageUtils.compositeImage(basePath,logoPath);


        System.out.println("========");
    }





}
