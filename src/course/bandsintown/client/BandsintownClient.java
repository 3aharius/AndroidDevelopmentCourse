package course.bandsintown.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import course.bandsintown.entity.Event;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BandsintownClient {

    private static final String HTTP_GET = "GET";
    private static final String EVENTS_REQUEST_URL_TEMPLATE = "http://api.bandsintown.com/artists/%s/events.json";
    private static final String DATE_FORMAT = "YYYY-MM-DD'T'hh:mm:ss";

    public List<Event> getEvents(String artistName) throws IOException, EncoderException {
        String requestLink= getRequestLink(artistName);
        System.out.println(requestLink);
        String response = sendRequest(requestLink);
        System.out.println(response);
        List<Event> events = parsJsonToEvents(response);
        return events;
    }

    private String getRequestLink(String artistName) throws EncoderException {
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
        System.out.println(responseCode);
        String serverResponse = getStrFromInputStream(con.getInputStream());
        return serverResponse;
    }

    private List<Event> parsJsonToEvents(String jsonEvents){
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
        List<Event> events = gson.fromJson(jsonEvents, new TypeToken<ArrayList<Event>>() {}.getType());
        return events;
    }
}
