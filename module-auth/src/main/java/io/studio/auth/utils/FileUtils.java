package io.studio.auth.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Date:2023/12/5 9:54
 *
 * @Author:poboking
 */
@Component
public class FileUtils {
    public static String write(byte[] fileContent, String fileName)throws IOException {
        System.out.println("work in write");
        String filePath ="D:/uploadFileSet/" + fileName;
        Files.write(Paths.get(filePath), fileContent);
        return filePath;
    }
}
