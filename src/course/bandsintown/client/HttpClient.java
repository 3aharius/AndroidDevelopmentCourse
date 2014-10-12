package course.bandsintown.client;

import course.bandsintown.utils.FileUtil;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient implements IClient {

    private static final String HTTP_GET = "GET";
    private static final int HTTP_STATUS_OK = 200;
    private static final String EVENTS_REQUEST_URL_TEMPLATE = "http://api.bandsintown.com/artists/%s/events.json";

    public String getData(String artistName) throws IOException {
        String requestLink = null;
        try {
            requestLink = geberateRequestLink(artistName);
        } catch (EncoderException ex) {
            throw new IOException(ex);
        }
        String response = sendRequest(requestLink);
        saveDataToStorage(artistName, response);
        return response;
    }

    private String geberateRequestLink(String artistName) throws EncoderException {
        URLCodec codec = new URLCodec();
        String encodedArtist = codec.encode(artistName).replaceAll("\\+", "%20");
        String requestLink = String.format(EVENTS_REQUEST_URL_TEMPLATE, encodedArtist);
        return requestLink;
    }

    private String getStrFromInputStream(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String inputLine;
        try {
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
        return response.toString();
    }

    private String sendRequest(String requestLink) throws IOException {
        URL requestUrl = new URL(requestLink);
        HttpURLConnection con = (HttpURLConnection) requestUrl.openConnection();
        con.setRequestMethod(HTTP_GET);
        con.setDoOutput(true);
        con.connect();
        int responseCode = con.getResponseCode();
        if(responseCode == HTTP_STATUS_OK) {
            String serverResponse = getStrFromInputStream(con.getInputStream());
            return serverResponse;
        }
        return "";
    }

    private void saveDataToStorage(String artistName, String data) throws IOException {
        File eventsFile = FileUtil.getEventsFile(artistName);
        FileUtil.saveDataToFile(eventsFile, data);
    }

}
