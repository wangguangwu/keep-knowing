package com.wangguangwu.keepknowing.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author wangguangwu
 */
public final class FileReadUtil {

    private FileReadUtil() {
    }

    public static String readFile(String filename) {
        try (InputStream inputStream = FileReadUtil.class.getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("文件[" + filename + "]不存在");
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line).append(System.lineSeparator());
                }
                String content = stringBuilder.toString().trim();
                return content.startsWith("\uFEFF") ? content.substring(1) : content;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("读取文件[" + filename + "]失败", e);
        }
    }
}
