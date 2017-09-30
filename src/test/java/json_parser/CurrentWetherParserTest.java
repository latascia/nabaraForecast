package json_parser;

import org.junit.Test;
import report.CurrentWeather;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

/**
 * Created by Nata on 29.09.17.
 */
public class CurrentWetherParserTest {

    @Test
    public void testNormalStringGetCoordinates() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertEquals(report.getCoordinates(), "051.51:-0.13");
    }

    @Test
    public void testNormalStringGetTemperature() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertEquals(report.getCurrentTemperatureInKelvin(), 280.30);
    }

    @Test
    public void testNormalStringGetCityName() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertEquals(report.getCityName(), "London");
    }

    @Test
    public void testNormalStringGetCountryCode() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertEquals(report.getCountryCode(), "200");
    }

    @Test
    public void testNoNameInStringGetCityName() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertNull(report.getCityName());
    }

    @Test
    public void testNoCoordinatesInStringGetCoordinates() {
        String json = "{\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London\",\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertNull(report.getCoordinates());
    }

    @Test
    public void testNoCountryCodeInStringGetCountryCode() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"temp\":280.32,\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertNull(report.getCountryCode());
    }

    @Test
    public void testNoCurrentWeatherInStringGetCurrentWeather() {
        String json = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51},\"weather\":[{\"id\":300,\"main\":\"Drizzle\"," +
                "\"description\":\"light intensity drizzle\",\"icon\":\"09d\"}],\"base\":\"stations\",\"main\":{" +
                "\"pressure\":1012,\"humidity\":81,\"temp_min\":279.15,\"temp_max\":281.15}," +
                "\"visibility\":10000,\"wind\":{\"speed\":4.1,\"deg\":80},\"clouds\":{\"all\":90},\"dt\":1485789600," +
                "\"sys\":{\"type\":1,\"id\":5091,\"message\":0.0103,\"country\":\"GB\",\"sunrise\":1485762037," +
                "\"sunset\":1485794875},\"id\":2643743,\"name\":\"London,\"cod\":200}";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertNull(report.getCurrentTemperatureInKelvin());
    }

    @Test
    public void testIfJsonStringEqualsNull() {
        String json = null;
        try {
            CurrentWeather report = new CurrentWeather(null, null);
            JSONparser.parseJsonForCurrentWeather(json, report);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfJsonStringIsEmptyGetCoordinates() {
        String json = "";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertNull(report.getCoordinates());
    }

    @Test
    public void testIfJsonStringIsEmptyGetTemperature() {
        String json = "";
        CurrentWeather report = new CurrentWeather(null, null);
        JSONparser.parseJsonForCurrentWeather(json, report);
        assertEquals(0, report.getCurrentTemperatureInKelvin());
    }
}
