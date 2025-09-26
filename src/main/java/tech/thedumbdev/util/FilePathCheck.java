package tech.thedumbdev.util;

import java.io.File;

public class FilePathCheck {
    // Let's say this only checks about the existance of the folder,
    // In the query processor, we'll make sure that the file exist i.e. 12312341.log
    public static boolean vaildFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }
}
