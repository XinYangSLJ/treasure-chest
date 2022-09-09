package org.treasure.chest.dev.template.util;

import com.google.common.collect.Lists;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * @author lj
 * @version 1.0.0
 * @Description
 * @createTime 2022-09-07 16:36
 */
public class FileUtils {

    private FileUtils(){}

    /**
     * 逐行读取文本文件中的内容
     *
     * @param filePath
     * @return
     */
    public static List<String[]> readTextLines(String filePath, String separator){
        InputStream inputStream = null;
        try {
            if (Objects.nonNull(filePath)) {
                File textFile = new File(filePath);
                if (!textFile.exists()) {
                    throw new RuntimeException("The path " + textFile + " is not exists.");
                }
                inputStream = new FileInputStream(textFile);
                if (Objects.isNull(inputStream)) {
                    throw new RuntimeException("Text content not found!!!");
                }
            }
            List<String[]> splitLines = Lists.newLinkedList();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 512);
            String line ;
            while ((line = br.readLine()) != null){
                String[] arrays = line.split(separator);
                splitLines.add(arrays);
            }
            return splitLines;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }




    static class StringSeparator{
        static final String DIAMOND = "<>";
        static final String COMMA = ",";
    }
}
