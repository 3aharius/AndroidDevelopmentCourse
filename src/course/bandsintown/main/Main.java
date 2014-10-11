package course.bandsintown.main;

import course.bandsintown.client.BandsintownClient;
import org.apache.commons.codec.EncoderException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, EncoderException {

        BandsintownClient client = new BandsintownClient();
        //client.getEvents("Dark Tranquillity?!@#$%^&*()|\\/");
        client.getEvents("Dark Tranquillity");
    }
}
