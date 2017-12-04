package http_connection;

import exceptions.CannotReadContentException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nata on 24.09.17.
 */
public class HttpUtility {
    private HttpURLConnection connection;

    public HttpUtility(String url) throws IOException {
        openConnection(url);
    }

    public void openConnection(String url) throws IOException {
        connection = (HttpURLConnection) (new URL(url).openConnection());
    }

    HttpURLConnection getConnection() {
        return connection;
    }

    public String getPageContent() throws CannotReadContentException {
        StringBuilder contentGatherer = new StringBuilder();
        try {
            BufferedReader stream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while (stream.ready()) {
                contentGatherer.append(stream.readLine());
            }
            String content = contentGatherer.toString();
            if (content.equals("")) {
                throw new CannotReadContentException();
            }
            return content;
        } catch (IOException e) {
            throw new CannotReadContentException();
        }

    }
}
