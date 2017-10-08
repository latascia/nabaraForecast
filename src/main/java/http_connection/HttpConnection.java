package http_connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Nata on 24.09.17.
 */
public class HttpConnection {
    public static HttpURLConnection openConnection(String url) {
        try {
            return (HttpURLConnection) (new URL(url).openConnection());
        } catch (IOException e) {
            return null;
        }

    }
}
