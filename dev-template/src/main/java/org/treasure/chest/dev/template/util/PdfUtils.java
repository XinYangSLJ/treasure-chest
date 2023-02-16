package org.treasure.chest.dev.template.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Entities;
import org.treasure.chest.dev.template.util.support.CustomFrontProvider;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author lj
 * @version 1.0.0
 * @Description PDF工具类
 * @createTime 2022-12-02 14:42
 */
@Slf4j
public class PdfUtils {

    private PdfUtils(){}


    /**
     * 通过html转换成为pdf文件
     *
     * @param htmlString  富文本字符串
     * @param pdfPath pdf 文件保存地址
     */
    public static void htmlToPDF(String htmlString,String pdfPath) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(pdfPath));
            document.open();
            document.addCreationDate();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream inputStream = new ByteArrayInputStream(htmlString.getBytes(StandardCharsets.UTF_8));
            worker.parseXHtml(pdfWriter, document, inputStream,null,
                    StandardCharsets.UTF_8,new CustomFrontProvider());
            document.close();
        } catch (Exception e) {
            log.error("Html convert to PDF exception! {}", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过html转换成为pdf文件
     *
     * @param htmlString  富文本字符串
     *
     */
    public static byte[] htmlToPDF(String htmlString) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] result = null;
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document,out);
            document.open();
            document.addCreationDate();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream inputStream = new ByteArrayInputStream(htmlString.getBytes(StandardCharsets.UTF_8));
            worker.parseXHtml(pdfWriter, document, inputStream,null,
                    StandardCharsets.UTF_8,new CustomFrontProvider());
            document.close();
            result = out.toByteArray();
        } catch (Exception e) {
            log.error("Html convert to PDF exception! {}", e);
            throw new RuntimeException(e);
        } finally {
            out.close();
        }
        return result;
    }

    /**
     * 将富文解析成标准html后转换成为pdf文件
     *
     * @param textString  富文本字符串
     *
     */
    public static byte[] htmlParseToPDF(String textString) throws IOException {
        byte[] result;
        try {
            /* 先解析成标准html,防止富文本中特殊情况如<br> 标签没有结束标签等 */
            org.jsoup.nodes.Document doc = Jsoup.parse(textString);
            doc.outputSettings().syntax(org.jsoup.nodes.Document.OutputSettings.Syntax.xml);
            doc.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            String htmlString = doc.html();
            /* 进一步解析html，输出PDF字节流 */
            result = htmlToPDF(htmlString);
        } catch (Exception e) {
            log.error("Method【htmlParseToPDF】 execute, Html convert to PDF exception! {}", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 通过富文本转换成为pdf文件
     * @param htmlString 富本文字符串
     * @param pdfPath pdf 保存地址
     * @param author  pdf作者
     * @param creator pdf创建者
     * @param subject pdf主题
     * @param title pdt标题
     */
    public static void htmlToPDF(String htmlString,String pdfPath,String author,String creator,String subject,String title) {
        try {
            Document document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream(pdfPath));
            document.open();
            document.addAuthor(author);
            document.addCreator(creator);
            document.addSubject(subject);
            document.addTitle(title);
            document.addCreationDate();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            worker.parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlString.getBytes(StandardCharsets.UTF_8)),
                    null, Charset.forName("UTF-8"),new CustomFrontProvider());
            document.close();
        } catch (Exception e) {
            log.error("Html convert to PDF exception! {}", e);
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        String htmlStr = "<p>哈哈</p><p><br</br></p><p>我的。</p>";

//        htmlToPDF(htmlStr, "C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\锅圈\\aa.pdf");
        byte[] bytes = htmlParseToPDF(htmlStr);
//        htmlToPDF(htmlStr, "C:\\Users\\Dmall-CD-Tech01\\Desktop\\dmall开发\\锅圈\\aa.pdf","jun","冷处偏佳","新冠疫情","上海新冠疫情政策");
    }
}
