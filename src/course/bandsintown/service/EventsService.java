package course.bandsintown.service;

import course.bandsintown.client.IClient;
import course.bandsintown.entity.Event;
import course.bandsintown.handler.JsonHandler;
import org.apache.commons.codec.EncoderException;

import java.io.IOException;
import java.util.List;

public class EventsService {

    private IClient client;
    private JsonHandler dataHandler;

    public EventsService(IClient client, JsonHandler dataHandler) {
        this.client = client;
        this.dataHandler = dataHandler;
    }

    public List<Event> getEvents(String artistName) throws IOException, EncoderException {
        String data = client.getData(artistName);
        return !(data == null || data.isEmpty()) ? dataHandler.parsJsonToEvents(data) : null;
    }

}
