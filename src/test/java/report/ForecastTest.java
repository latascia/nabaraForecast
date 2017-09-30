package report;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.fail;

/**
 * Created by Nata on 28.09.17.
 */
public class ForecastTest {
    //add null tests
    //add invalid tests
    @Test
    public void testIfGivenCitNameEqualsGotCityName() {
        String cityName = "Tallinn";
        Forecast report = new Forecast(cityName, null);
        assertEquals(cityName, report.getCityName());
    }

    @Test
    public void testIfCityNameIsNull() {
        CurrentWeather report = new CurrentWeather(null, null);
        assertNull(report.getCityName());
    }

    @Test
    public void testIfCityNameIsEmpty() {
        String cityName = "";
        CurrentWeather report = new CurrentWeather(cityName, null);
        assertEquals(cityName, report.getCityName());
    }

    @Test
    public void testIfGivenCountryCodeEqualsGotCountryCode() {
        String countryCode = "EE";
        Forecast report = new Forecast(null, countryCode);
        assertEquals(countryCode, report.getCountryCode());
    }

    @Test
    public void testIfCountryCodeIsNull() {
        CurrentWeather report = new CurrentWeather(null,null);
        assertNull(report.getCountryCode());
    }

    @Test
    public void testIfCountryCodeIsEmpty() {
        String countryCode = "";
        CurrentWeather report = new CurrentWeather(null, countryCode);
        assertEquals(countryCode, report.getCountryCode());
    }

    @Test
    public void testIfGivenLatitudeEqualsGotLatitude() {
        String latitude = "123.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("123.00:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsTwoNumbers() {
        String latitude = "23.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("023.00:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsOneNumber() {
        String latitude = "3.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("003.00:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeEqualsGotLongitude() {
        String longitude = "223.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx.xx:223.00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsTwoNumbers() {
        String longitude = "23.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx.xx:023.00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsOneNumber() {
        String longitude = "3.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.00", longitude);
        assertEquals("xxx.00:003.00", report.getCoordinates());
    }

    @Test
    public void testIfGeoFormatIsRight() {
        String longitude = "223.00";
        String latitude = "157.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("157.00:223.00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsNegative() {
        String longitude = "-223.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx.xx:-223.00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsNegative() {
        String latitude = "-223.05";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("-223.05:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatAnLonBothAreNegative() {
        String latitude = "-223.00";
        String longitude = "-145.00";
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("-223.00:-145.00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatHasMoreDecimals() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("123.12345", "yyy.yy");
        assertEquals("123.12:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeHasMoreDecimalsRound() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("123.12945", "yyy.yy");
        assertEquals("123.13:yyy.yy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimals() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", "123.1235");
        assertEquals("xxx.xx:123.12", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimalsRound() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", "123.12945");
        assertEquals("xxx.xx:123.13", report.getCoordinates());
    }

    @Test
    public void testIfLatitudeIsNull() {
        Forecast report = new Forecast(null, null);
        try {
            report.setCoordinates(null, "yyy.yy");
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLongitudeIsNull() {
        Forecast report = new Forecast(null, null);
        try {
            report.setCoordinates("xxx.xx", null);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLongitudeAndLatitudeBothAreNull() {
        Forecast report = new Forecast(null, null);
        try {
            report.setCoordinates(null, null);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLatitudeIsEmpty() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("", "yyy.yy");
        assertEquals(":yyy.yy", report.getCoordinates());

    }

    @Test
    public void testIfLongitudeIsEmpty() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("xxx.xx", "");
        assertEquals("xxx.xx:", report.getCoordinates());
    }

    @Test
    public void testIfLongitudeAndLatitudeBothAreEmpty() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates("", "");
        assertEquals(":", report.getCoordinates());
    }

    @Test
    public void testIfGivenMinimumTemperatureEqualsGot() {
        double min = 10;
        Forecast report = new Forecast(null, null);
        report.setTemperature(25, min);
        assertEquals(min, report.getMinimumTemperature());
    }

    @Test
    public void testIfGivenFloatMinTemperatureEqualsGot() {
        double min = 10.005;
        Forecast report = new Forecast(null, null);
        report.setTemperature(25, min);
        assertEquals(min, report.getMinimumTemperature());
    }

    @Test
    public void testIfGivenMaximumTemperatureEqualsGot() {
        double max = 10;
        Forecast report = new Forecast(null, null);
        report.setTemperature(max, 0);
        assertEquals(max, report.getMaximumTemperature());
    }

    @Test
    public void testIfGivenDoubleMaximumTemperatureEqualsGot() {
        double max = 10.33;
        Forecast report = new Forecast(null, null);
        report.setTemperature(max, 0);
        assertEquals(max, report.getMaximumTemperature());
    }
}
