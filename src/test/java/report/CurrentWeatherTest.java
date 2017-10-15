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
        double latitude = 123;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("123,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsTwoNumbers() {
        double latitude = 23.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("023,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsOneNumber() {
        double latitude = 3;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("003,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeEqualsGotLongitude() {
        double longitude = 223.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsTwoNumbers() {
        double longitude = 23.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:023,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsOneNumber() {
        double longitude = 3.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:003,00", report.getCoordinates());
    }

    @Test
    public void testIfGeoFormatIsRight() {
        double longitude = 223;
        double latitude = 157;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("157,00:223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsNegative() {
        double longitude = -223.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:-223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsNegative() {
        double latitude = -223.05;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("-223,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatAnLonBothAreNegative() {
        double latitude = -223.00;
        double longitude = -145.00;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("-223,00:-145,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatHasMoreDecimals() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(123.12345, 0);
        assertEquals("123,12:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeHasMoreDecimalsRound() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(123.12945, 0);
        assertEquals("123,13:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimals() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, 123.1235);
        assertEquals("000,00:123,12", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimalsRound() {
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCoordinates(0, 123.12945);
        assertEquals("000,00:123,12", report.getCoordinates());
    }


    @Test
    public void testIfGivenCurrentTempEqualsGot() {
        double currentTemp = 225.05;
        CurrentWeather report = new CurrentWeather(null, null);
        report.setCurrentTemperatureKelvin(currentTemp);
        assertEquals(currentTemp, report.getCurrentTemperatureInKelvin());
    }
}