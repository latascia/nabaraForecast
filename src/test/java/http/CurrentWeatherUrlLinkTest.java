package http;

import http_connection.RequestType;
import http_connection.UrlLinkGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Nata on 24.09.17.
 */

public class CurrentWeatherUrlLinkTest {
    @Test
    public void testCreateUrlNullCityName() {
        assertNull(UrlLinkGenerator.generateUrlByCityName(RequestType.CURRENT_WEATHER, null));
    }

    @Test
    public void testCreateUrlEmptyName() {
        assertNull(UrlLinkGenerator.generateUrlByCityName(RequestType.CURRENT_WEATHER, ""));
    }

    @Test
    public void testCreateUrlNormalName() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityName(RequestType.CURRENT_WEATHER, "London"));
    }

    @Test
    public void testCreateUrlNullNameNullCode(){
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, null, null));
    }
    @Test
    public void testCreateUrlNullNameNormalCode(){
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, null, "uk"));
    }

    @Test
    public void testCreateUrlNormalNameNullCode(){
        assertEquals("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", null));
    }

    @Test
    public void testCreateUrlEmptyNameNullCode() {
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "", null));
    }

    @Test
    public void testCreateUrlNullNameEmptyCode() {
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, null, ""));
    }

    @Test
    public void testCreateUrlEmptyNameNormalCode(){
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "", "uk"));
    }

    @Test
    public void testCreateUrlNormalNameEmptyCode(){
        assertEquals("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", ""));
    }

    @Test
    public void testCreateUrlEmptyNameEmptyCode(){
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "", ""));
    }

    @Test
    public void testCreateUrlNormalNameInvalidCode(){
        assertEquals("https://api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", "bla"));
    }

    @Test
    public void testCreateUrlNormalNameNormalCode(){
        assertEquals("https://api.openweathermap.org/data/2.5/weather?q=Tallinn,ee&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "Tallinn", "ee"));
    }

    @Test(expected = NullPointerException.class)
    public void testIsCountryCodeValidNullCountryCodeThrowsEx() {
        UrlLinkGenerator.isCountryCodeValid(null);
    }
    @Test
    public void testIsCorrectCountryCodeValid() {
        assertEquals(true, UrlLinkGenerator.isCountryCodeValid("FK"));
    }

    @Test
    public void testIsLowerCaseCountryCodeValid() {
        assertEquals(true, UrlLinkGenerator.isCountryCodeValid("fk"));
    }

    @Test
    public void testIsInvalidCountryCodeValid() {
        assertEquals(false, UrlLinkGenerator.isCountryCodeValid("$$"));
        assertEquals(false, UrlLinkGenerator.isCountryCodeValid("FS"));
        assertEquals(false, UrlLinkGenerator.isCountryCodeValid("rar"));
        assertEquals(false, UrlLinkGenerator.isCountryCodeValid("015875"));
    }
    @Test
    public void testCreateUrlNegativeLatitudeNegativeLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=-156&lon=-120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, -156, -120));
    }

    @Test
    public void testCreateUrlPositiveLatitudePositiveLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=156&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 156, 120));
    }

    @Test
    public void testCreateUrlShortLatitudeLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=1&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 1, 120));
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=1&lon=1&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 1, 1));
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=120&lon=1&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 120, 1));
    }

    @Test
    public void testCreateUrlNegativeLatitudePositiveLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=-100&lon=200&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, -100, 200));
    }

    @Test
    public void testCreateUrlPositiveLatitudeNegativeLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=100&lon=-120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 100, -120));
    }

    @Test
    public void testCreateUrlZeroLatitudeZeroLongitude() {
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 0, 120));
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=120&lon=0&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 120, 0));
        assertEquals("https://api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 0, 0));
    }
}
