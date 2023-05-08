package com.wangguangwu.keepknowing.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * @author wangguangwu
 */
@Slf4j
public final class DownloadUtil {

    private DownloadUtil() {
    }

    /**
     * 下载目录
     */
    private static final String BASE_DIR = "/Users/wangguangwu/workSpace/crawler";

    /**
     * 下载文件
     *
     * @param fileUrl  文件 url
     * @param fileName 文件名称
     */
    public static String download(String fileUrl, String dir, String fileName, String type) {
        String fileDir = BASE_DIR + File.separator + dir;
        String filePath = fileDir + File.separator + fileName + "." + type;

        HttpURLConnection connection = null;
        try {
            connection = HttpClientUtil.getConnection(fileUrl);

            if (connection == null) {
                return "";
            }

            FileUtil.createDirIfNotExists(fileDir);
            FileUtil.createFileIfNotExists(filePath);

            try (InputStream inputStream = connection.getInputStream();
                 FileOutputStream output = new FileOutputStream(filePath)) {
                FileUtil.writeFile(inputStream, output, connection.getContentLength());
            }
        } catch (IOException e) {
            log.error("Error downloading file: {}", fileUrl, e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return filePath;
    }
}
