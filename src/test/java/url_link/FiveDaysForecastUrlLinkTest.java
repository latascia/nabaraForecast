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
        assertEquals("api.openweathermap.org/data/2.5/forecast?q=Tallinn,ee&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.FORECAST, "Tallinn", "ee"));
    }

    @Test
    public void testCreateUrlLatitudeLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/forecast?lat=156&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.FORECAST, 156, 120));
    }
}
