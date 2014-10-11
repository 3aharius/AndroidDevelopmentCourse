package course.bandsintown.main;

import course.bandsintown.client.BandsintownClient;
import course.bandsintown.entity.Event;
import course.bandsintown.entity.Venue;
import org.apache.commons.codec.EncoderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, EncoderException {

        System.out.print("Enter an artist name: ");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String artistName = consoleReader.readLine();
        System.out.println();
        try {
            BandsintownClient client = new BandsintownClient();
            List<Event> events = client.getEvents(artistName);
            if(events != null && !events.isEmpty()){
                for(Event event : events) {
                    printEventInformation(event);
                }
            } else {
                System.out.println("Sorry, have nothing for you...");
            }
        } catch (IOException | EncoderException ex) {
            System.out.println("An error occurred while processing your request. Please, try again.");
        }
    }

    private static void printEventInformation(Event event) {
        System.out.println("Event date: " + event.getDatetime());
        System.out.println("Event ticket url: " + event.getTicketUrl());
        Venue venue = event.getVenue();
        System.out.println("Event venue country: " + venue.getCountry());
        System.out.println("Event venue city: " + venue.getCity());
        System.out.println("Event venue name: " + venue.getName());
        System.out.println("---------------------------------------");
    }
}
