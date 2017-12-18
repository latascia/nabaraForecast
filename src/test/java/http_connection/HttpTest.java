package http_connection;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;


public class HttpTest {

    @Test(expected = IOException.class)
    public void testConnectToWrongLink() throws IOException {
        String url = "wrongurl";
        HttpUtility utility = new HttpUtility(url);
    }

    @Test
    public void testConnectToNormalLink() {
        String url = "https://api.openweathermap.org/data/2.5/weather?id=2172797&appid=e8f64f746b108351d35e396af44d3ae0";
        try {
            HttpUtility utility = new HttpUtility(url);
            HttpURLConnection connection = utility.getConnection();

            assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
        } catch (IOException e) {
            fail(e.getMessage());
        }
    }
}
