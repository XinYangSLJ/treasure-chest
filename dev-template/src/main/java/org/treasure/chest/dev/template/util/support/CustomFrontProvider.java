package org.treasure.chest.dev.template.util.support;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author lj
 * @version 1.0.0
 * @Description Front定制化
 * @createTime 2022-12-02 14:56
 */
@Slf4j
public class CustomFrontProvider extends XMLWorkerFontProvider {

    @Override
    public Font getFont(final String fontName, final String encoding,
                        final boolean embedded, final float size, final int style,
                        final BaseColor color) {
        try {
            BaseFont bf = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H",
                    BaseFont.NOT_EMBEDDED);
            Font font = new Font(bf, size, style, color);
            font.setColor(color);
            return font;
        } catch (DocumentException e) {
            log.error("Custom front initialize fail! {}", e);
        } catch (IOException e) {
            log.error("Custom front initialize fail! {}", e);
        }
        return super.getFont(fontName, encoding, embedded, size, style, color);
    }
}
