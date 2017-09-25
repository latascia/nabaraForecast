package url_link;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Nata on 24.09.17.
 */
public class FiveDaysForecastUrlLinkTest {

    @Test
    public void testCreateUrlName() {
        assertEquals("api.openweathermap.org/data/2.5/forecast?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityName(RequestType.FORECAST, "London"));
    }

    @Test
    public void testCreateUrlNameCode(){
        assertEquals("api.openweathermap.org/data/2.5/forecast?q=London,uk&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.FORECAST, "London", "uk"));
    }

    @Test
    public void testCreateUrlID() {
        assertEquals("api.openweathermap.org/data/2.5/forecast?id=1567&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityID(RequestType.FORECAST, 1567));
    }

    @Test
    public void testCreateUrlLatitudeLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/forecast?lat=156&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.FORECAST, 156, 120));
    }

    @Test
    public void testCreateUrlZipCode() {
        assertEquals("api.openweathermap.org/data/2.5/forecast?zip=94040,us&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByZipCode(RequestType.FORECAST, 94040, "us"));
    }
}
