package course.bandsintown.main;

import course.bandsintown.service.EventsService;
import course.bandsintown.client.FileClient;
import course.bandsintown.client.HttpClient;
import course.bandsintown.client.IClient;
import course.bandsintown.entity.Event;
import course.bandsintown.entity.Venue;
import course.bandsintown.handler.JsonHandler;
import course.bandsintown.utils.FileUtil;
import org.apache.commons.codec.EncoderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException, EncoderException {

        System.out.print("Enter an artist name: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String artistName = consoleReader.readLine();
        System.out.println();
        IClient client = getClient(artistName);
        JsonHandler dataHandler = new JsonHandler();
        EventsService service = new EventsService(client, dataHandler);
        try {
            List<Event> events = service.getEvents(artistName);
            if(events != null && !events.isEmpty()){
                for(Event event : events) {
                    printEventInformation(event);
                }
            } else {
                System.out.println("Sorry, have nothing for you...");
            }
        } catch (IOException ex) {
            System.out.println("An error occurred while processing your request. Please, try again.");
        }
    }

    private static IClient getClient(String artistName) {
        if(FileUtil.checkEventFileExists(artistName)) {
            return new FileClient();
        } else {
            return new HttpClient();
        }
    }

    private static void printEventInformation(Event event) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.getDefault());
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.getDefault());
        System.out.println("Event date: " + dateFormat.format(event.getDatetime()));
        System.out.println("Event time: " + timeFormat.format(event.getDatetime()));
        System.out.println("Event ticket url: " + event.getTicketUrl());
        Venue venue = event.getVenue();
        System.out.println("Event venue country: " + venue.getCountry());
        System.out.println("Event venue city: " + venue.getCity());
        System.out.println("Event venue name: " + venue.getName());
        System.out.println("---------------------------------------");
    }
}
