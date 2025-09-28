package tech.thedumbdev.reader;

import tech.thedumbdev.pojo.Log;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader{
    public File folder;

    public FileReader() {
        File folder = new File(System.getProperty("user.home") + File.separator + "logs");
        if(!folder.exists() || !folder.isDirectory()) {
            boolean result = folder.mkdir();
            if(!result) {
                throw new RuntimeException("Unable to create logs folder");
            }
        }
        this.folder = folder;
    }

    @Override
    public List<Log> read(String logFile) {
        List<Log> logs = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File file = new File(this.folder, logFile);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while(true) {
                try {
                    Log log = (Log) ois.readObject();
                    logs.add(log);
                } catch (EOFException e) {
                    break;
                }
            }

        }

        catch (Exception e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            }
            catch (Exception e) {
                //noinspection ThrowFromFinallyBlock
                throw new RuntimeException(e);
            }
        }

        return logs;
    }
}
