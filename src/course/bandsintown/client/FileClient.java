package course.bandsintown.client;

import course.bandsintown.utils.FileUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileClient implements IClient {

    public String getData(String artistName) throws IOException {
        File eventFile = FileUtil.getEventsFile(artistName);
        if(!eventFile.exists()) {
            return "";
        }
        String data = readFile(eventFile);
        return data;
    }

    private String readFile(File eventFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(eventFile));
        StringBuilder sBuilder = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                sBuilder.append(line);
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }
        return sBuilder.toString();
    }
}
