package report;

import org.junit.Test;

import java.util.WeakHashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.fail;

/**
 * Created by Nata on 28.09.17.
 */
public class CurrentWeatherTest {
    //add null tests
    //add invalid tests
    @Test
    public void testIfGivenCitNameEqualsGotCityName() {
        String cityName = "Tallinn";
        CurrentWeather report = new CurrentWeather(cityName, null);
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
        CurrentWeather report = new CurrentWeather(null, countryCode);
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
        String latitude = "123";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, "yyy");
        assertEquals("123:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsTwoNumbers() {
        String latitude = "23.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("023:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsOneNumber() {
        String latitude = "3";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("003:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeEqualsGotLongitude() {
        String longitude = "223.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx:223", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsTwoNumbers() {
        String longitude = "23.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx:023", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsOneNumber() {
        String longitude = "3.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.00", longitude);
        assertEquals("xxx:003", report.getCoordinates());
    }

    @Test
    public void testIfGeoFormatIsRight() {
        String longitude = "223";
        String latitude = "157";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("157:223", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsNegative() {
        String longitude = "-223.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", longitude);
        assertEquals("xxx:-223", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsNegative() {
        String latitude = "-223.05";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, "yyy.yy");
        assertEquals("-223:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatAnLonBothAreNegative() {
        String latitude = "-223.00";
        String longitude = "-145.00";
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("-223:-145", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatHasMoreDecimals() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("123.12345", "yyy.yy");
        assertEquals("123:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeHasMoreDecimalsRound() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("123.12945", "yyy.yy");
        assertEquals("123:yyy", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimals() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", "123.1235");
        assertEquals("xxx:123", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimalsRound() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", "123.12945");
        assertEquals("xxx:123", report.getCoordinates());
    }

    @Test
    public void testIfLatitudeIsNull() {
        CurrentWeather report = new CurrentWeather(null, null);
        try {
            report.setCoordinates(null, "yyy.yy");
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLongitudeIsNull() {
        CurrentWeather report = new CurrentWeather(null, null);
        try {
            report.setCoordinates("xxx.xx", null);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLongitudeAndLatitudeBothAreNull() {
        CurrentWeather report = new CurrentWeather(null, null);
        try {
            report.setCoordinates(null, null);
        } catch (NullPointerException e) {
            fail();
        }
    }

    @Test
    public void testIfLatitudeIsEmpty() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("", "yyy.yy");
        assertEquals("000:yyy", report.getCoordinates());

    }

    @Test
    public void testIfLongitudeIsEmpty() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("xxx.xx", "");
        assertEquals("xxx:000", report.getCoordinates());
    }

    @Test
    public void testIfLongitudeAndLatitudeBothAreEmpty() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates("", "");
        assertEquals("000:000", report.getCoordinates());
    }

    @Test
    public void testIfGivenCurrentTempEqualsGot() {
        double currentTemp = 225.05;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCurrentTemperatureKelvin(currentTemp);
        assertEquals(currentTemp, report.getCurrentTemperatureInKelvin());
    }
}
