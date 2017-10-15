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
        double latitude = 123.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("123,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsTwoNumbers() {
        double latitude = 23.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("023,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsOneNumber() {
        double latitude = 3.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("003,00:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeEqualsGotLongitude() {
        double longitude = 223.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsTwoNumbers() {
        double longitude = 23.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:023,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsOneNumber() {
        double longitude = 3.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:003,00", report.getCoordinates());
    }

    @Test
    public void testIfGeoFormatIsRight() {
        double longitude = 223.00;
        double latitude = 157.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("157,00:223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeIsNegative() {
        double longitude = -223.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(0, longitude);
        assertEquals("000,00:-223,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeIsNegative() {
        double latitude = -223.05;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, 0);
        assertEquals("-223,05:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatAnLonBothAreNegative() {
        double latitude = -223.00;
        double longitude = -145.00;
        Forecast report = new Forecast(null, null);
        report.setCoordinates(latitude, longitude);
        assertEquals("-223,00:-145,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatHasMoreDecimals() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates(123.12345, 0);
        assertEquals("123,12:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLatitudeHasMoreDecimalsRound() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates(123.12945, 0);
        assertEquals("123,12:000,00", report.getCoordinates());
    }

    @Test
    public void testIfGivenLongitudeHasMoreDecimals() {
        Forecast report = new Forecast(null, null);
        report.setCoordinates(0, 123.1235);
        assertEquals("000,00:123,12", report.getCoordinates());
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
