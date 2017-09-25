package forecast;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by Nata on 24.09.17.
 */
public class ForecastTest {
    @Test
    public void testGotJustCityName() {
        String exampleJson = "{\"name\":\"London\"}";
        Forecast controllable = new Forecast(exampleJson);
        assertEquals("London", controllable.getName());
        assertNull(controllable.getCoordinates());
        assertEquals(0, controllable.getMaxTemperature(controllable.getThreeDaysTemperature()));
        assertEquals(0, controllable.getMinTemperature(controllable.getThreeDaysTemperature()));
        assertNull(controllable.getCurrentTemrature());
    }

    @Test
    public void testGotJustCoordinates() {
        String exampleJson = "{\"coord\":{\"lon\":-0.13,\"lat\":51.51}}";
        Forecast controllable = new Forecast(exampleJson);
        assertNull(controllable.getName());
        assertEquals("-000.051", controllable.getCoordinates());
        assertEquals(0, controllable.getMaxTemperature(controllable.getThreeDaysTemperature()));
        assertEquals(0, controllable.getMinTemperature(controllable.getThreeDaysTemperature()));
        assertNull(controllable.getCurrentTemrature());
    }

    @Test
    public void testGotJustCurrentTemperature() {
        String exampleJson = "{\"temp\":280.32}";
        Forecast controllable = new Forecast(exampleJson);
        assertNull(controllable.getName());
        assertNull(controllable.getCoordinates());
        assertEquals(0, controllable.getMaxTemperature(controllable.getThreeDaysTemperature()));
        assertEquals(0, controllable.getMinTemperature(controllable.getThreeDaysTemperature()));
        assertEquals("280.32", controllable.getCurrentTemrature());
    }

    // I need firstly to get known how JSON is working.
}
