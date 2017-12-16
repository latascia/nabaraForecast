package report;

import exceptions.CannotReadContentException;
import exceptions.ReportsDoNotMatchException;
import org.junit.Before;
import org.junit.Test;
import raw_data_storage.CurrentWeatherDataStorage;
import raw_data_storage.ForecastDataStorage;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CombinerTest {
    private StoragesToReportCombiner combiner;
    private ForecastDataStorage forecast;
    private CurrentWeatherDataStorage currentWeather = mock(CurrentWeatherDataStorage.class);

    @Before
    public void prepare() {
        forecast = mock(ForecastDataStorage.class);
        currentWeather = mock(CurrentWeatherDataStorage.class);
        combiner = new StoragesToReportCombiner(forecast, currentWeather);
    }

    @Test(expected = CannotReadContentException.class)
    public void testIfForecastNotReceivedThrowsCannotReadContentException() throws CannotReadContentException {
        when(forecast.isFailedToReceive()).thenReturn(true);
        when(currentWeather.isFailedToReceive()).thenReturn(false);
        combiner.checkIfMessageReceived();
    }

    @Test(expected = CannotReadContentException.class)
    public void testIfCurrentWeatherNotReceivedThrowsCannotReadContentException() throws CannotReadContentException {
        when(forecast.isFailedToReceive()).thenReturn(false);
        when(currentWeather.isFailedToReceive()).thenReturn(true);
        combiner.checkIfMessageReceived();
    }

    @Test(expected = CannotReadContentException.class)
    public void testIfNotDataReceivedThrowsCannotReadContentException() throws CannotReadContentException {
        when(forecast.isFailedToReceive()).thenReturn(true);
        when(currentWeather.isFailedToReceive()).thenReturn(true);
        combiner.checkIfMessageReceived();
    }

    @Test
    public void testIfAllDataReceivedDoNotThrowException() {
        try {
            when(forecast.isFailedToReceive()).thenReturn(false);
            when(currentWeather.isFailedToReceive()).thenReturn(false);
            combiner.checkIfMessageReceived();
        } catch (CannotReadContentException e) {
            fail();
        }
    }

    @Test
    public void testCityNamesEqualCombinationIsValidDoNotThrowException() {
        try {
            String cityName = "DamnName";
            when(forecast.getCityName()).thenReturn(cityName);
            when(currentWeather.getCityName()).thenReturn(cityName);
            combiner.checkIfCombinationIsValid();
        } catch (ReportsDoNotMatchException e) {
            fail();
        }
    }

    @Test (expected = ReportsDoNotMatchException.class)
    public void testCityNamesDoNotEqualThrowsReportsDoNotMatchException() throws ReportsDoNotMatchException {
        when(forecast.getCityName()).thenReturn("DamnName1");
        when(currentWeather.getCityName()).thenReturn("DamnName2");
        combiner.checkIfCombinationIsValid();
    }

    @Test
    public void testIfFormatAddsNumbersIfCoordinatesWithoutComa() {
        HashMap<String, Float> coordinates = new HashMap<>();
        coordinates.put("lat", 1f);
        coordinates.put("lon", 1f);
        when(forecast.getCoord()).thenReturn(coordinates);
        assertEquals("1,00:1,00", combiner.formatCoordinates());
    }

    @Test
    public void testIfFormatRemovesNumbersIfCoordinatesAreTooLongAfterComa() {
        HashMap<String, Float> coordinates = new HashMap<>();
        coordinates.put("lat", 1.1533f);
        coordinates.put("lon", 1.1922f);
        when(forecast.getCoord()).thenReturn(coordinates);
        assertEquals("1,15:1,19", combiner.formatCoordinates());
    }

    @Test
    public void testIfFormatRoundsCoordinatesTwoSignsAfterComa() {
        HashMap<String, Float> coordinates = new HashMap<>();
        coordinates.put("lat", 1.159f);
        coordinates.put("lon", 1.167f);
        when(forecast.getCoord()).thenReturn(coordinates);
        assertEquals("1,16:1,17", combiner.formatCoordinates());
    }

}
