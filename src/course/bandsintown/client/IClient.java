package course.bandsintown.client;

import java.io.IOException;

public interface IClient {

    String getData(String artistName) throws IOException;
}
