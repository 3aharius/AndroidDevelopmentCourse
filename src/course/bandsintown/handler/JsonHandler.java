package course.bandsintown.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import course.bandsintown.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class JsonHandler {

    private static final String DATE_FORMAT = "YYYY-MM-DD'T'hh:mm:ss";

    public List<Event> parsJsonToEvents(String jsonEvents){
        Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
        List<Event> events = gson.fromJson(jsonEvents, new TypeToken<ArrayList<Event>>() {}.getType());
        return events;
    }

}
