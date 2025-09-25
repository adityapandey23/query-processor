package tech.thedumbdev.util;

import java.io.File;

public class FilePathCheck {
    public static boolean vaildFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
