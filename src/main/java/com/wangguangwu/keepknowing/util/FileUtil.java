package com.wangguangwu.keepknowing.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author wangguangwu
 */
@SuppressWarnings("all")
public final class FileUtil {

    private FileUtil() {
    }

    private static final int MAX_BUFFER_SIZE = 10240;

    public static void createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static void createDirIfNotExists(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public static void writeFile(InputStream inputStream, OutputStream output, int fileSize) throws IOException {
        int downloaded = 0;
        while (downloaded < fileSize) {
            int bufferSize = Math.min(fileSize - downloaded, MAX_BUFFER_SIZE);
            byte[] buffer = new byte[bufferSize];

            int read;
            int currentDownload = 0;
            while (currentDownload < buffer.length) {
                read = inputStream.read();
                buffer[currentDownload++] = (byte) read;
            }

            output.write(buffer);
            downloaded += currentDownload;
        }
    }
}
