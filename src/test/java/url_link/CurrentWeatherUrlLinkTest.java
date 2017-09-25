package url_link;

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
        assertEquals("api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
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
        assertEquals("api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
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
        assertEquals("api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", ""));
    }

    @Test
    public void testCreateUrlEmptyNameEmptyCode(){
        assertNull(UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "", ""));
    }

    @Test
    public void testCreateUrlNormalNameInvalidCode(){
        assertEquals("api.openweathermap.org/data/2.5/weather?q=London&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", "bla"));
    }

    @Test
    public void testCreateUrlNormalNameNormalCode(){
        assertEquals("api.openweathermap.org/data/2.5/weather?q=London,uk&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.CURRENT_WEATHER, "London", "uk"));
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
    public void testCreateUrlZeroID() {
        assertEquals("api.openweathermap.org/data/2.5/weather?id=0&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityID(RequestType.CURRENT_WEATHER, 0));
    }

    @Test
    public void testCreateUrlPositiveID() {
        assertEquals("api.openweathermap.org/data/2.5/weather?id=1567&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityID(RequestType.CURRENT_WEATHER, 1567));
    }

    @Test
    public void testCreateUrlNegativeID() {
        assertEquals("api.openweathermap.org/data/2.5/weather?id=-1567&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByCityID(RequestType.CURRENT_WEATHER, -1567));
    }

    @Test
    public void testCreateUrlNegativeLatitudeNegativeLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=-156&lon=-120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, -156, -120));
    }

    @Test
    public void testCreateUrlPositiveLatitudePositiveLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=156&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 156, 120));
    }

    @Test
    public void testCreateUrlShortLatitudeLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=1&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 1, 120));
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=1&lon=1&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 1, 1));
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=120&lon=1&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 120, 1));
    }

    @Test
    public void testCreateUrlNegativeLatitudePositiveLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=-100&lon=200&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, -100, 200));
    }

    @Test
    public void testCreateUrlPositiveLatitudeNegativeLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=100&lon=-120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 100, -120));
    }

    @Test
    public void testCreateUrlZeroLatitudeZeroLongitude() {
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=0&lon=120&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 0, 120));
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=120&lon=0&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 120, 0));
        assertEquals("api.openweathermap.org/data/2.5/weather?lat=0&lon=0&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByGeoCoordinates(RequestType.CURRENT_WEATHER, 0, 0));
    }

    @Test
    public void testCreateUrlZipCode() {
        assertEquals("api.openweathermap.org/data/2.5/weather?zip=94040,us&appid=e8f64f746b108351d35e396af44d3ae0",
                UrlLinkGenerator.generateUrlByZipCode(RequestType.CURRENT_WEATHER, 94040, "us"));
    }
}
