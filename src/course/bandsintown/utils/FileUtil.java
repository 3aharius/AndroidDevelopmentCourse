package course.bandsintown.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileUtil {

    private static  final String STORAGE_FOLDER = "storage";
    private static  final String JSON_EXTENSION = ".json";

    public static boolean checkEventFileExists(String artistName){
        return getEventsFile(artistName).exists();
    }

    private static File getStorageFolder() {
        String appPath = new File("").getAbsolutePath();
        File storageFolder = new File(appPath + File.separator + STORAGE_FOLDER);
        return storageFolder;
    }

    public static File getEventsFile(String artistName) {
        File storage = getStorageFolder();
        File eventFile = new File(storage.getAbsolutePath() + File.separator + artistName + JSON_EXTENSION);
        return eventFile;
    }

    public static void saveDataToFile(File file, String content) throws IOException {
        File storage = getStorageFolder();
        if(!storage.exists()) {
            if(!storage.mkdir()) {
                throw new IOException("Can not create a storage folder " + storage.getAbsolutePath());
            }
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            out.println(content);
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

}
