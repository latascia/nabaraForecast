package http;

import http_connection.HttpConnection;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Created by Nata on 19.09.17.
 */
public class HttpTest {

    //!
    @Test (expected = UnknownHostException.class)
    public void testConnectToWrongLink() throws IOException {
        String url = "https://wrongurl.la";
        HttpURLConnection urlConn = HttpConnection.openConnection(url);

    }

    @Test
    public void testConnectToNormalLink() {
        String url = "https://api.openweathermap.org/data/2.5/weather?id=2172797&appid=e8f64f746b108351d35e396af44d3ae0";
        try {
            HttpURLConnection urlConn = HttpConnection.openConnection(url);

            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
