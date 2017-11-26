package json_parser;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import data_storage.DataStorage;
import data_storage.ForecastDataStorage;
import org.junit.Before;
import org.junit.Test;
import report.ForecastReport;

import java.util.HashMap;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Nata on 30.09.17.
 */
public class ForecastParserTest {
    // TODO: 1. mock storage. 2 mock temperature 3 assert

    private ForecastDataStorage storage;
    private ForecastReportBuilder parser;

    @Before
    public void prepareObjects() {
        storage = mock(ForecastDataStorage.class);
    //    when(storage.getList()).thenReturn(createTemperatureJson("00:00:00", 0, 0, 0));
        parser = new ForecastReportBuilder(storage);
    }

//    private HashMap<String, Object>[] createTemperatureJson(String time, float firstMinimum, float firstMaximum, int difference) {
//        HashMap<String, Object>[] list = new HashMap<String, Object>[72];
//        for (int i = 0; i < 72; i++) {
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("dt_txt", "2017-01-30 " + time);
//            map.put("main", (Object)("{\"temp_min\":" + firstMinimum + i * difference
//                    + "\"temp_max\":" + firstMaximum + i * difference + "}"));
//            list[i] = map;
//        }
//        return list;
//    }

    @Test
    public void testIfBuilderAsksForNameReportingAnswer() {
        Gson gson = new Gson();
        when(storage.getCod()).thenReturn("code");
        when(storage.getName()).thenReturn("name");
        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":112, \"lon\":110}", LinkedTreeMap.class));
        when(storage.getCity()).thenReturn((HashMap<String, Object>) gson.fromJson("{\"name\": \"name\", \"coord\": {\"lat\":112, \"lon\":110} }", HashMap.class));
        ForecastReport report = parser.getForecastReport();
        assertEquals(report.cityName, "name");
    }


    @Test
    public void testIfBuilderAsksForCodeReportingAnswer() {
        Gson gson = new Gson();
        when(storage.getCod()).thenReturn("code");
        when(storage.getName()).thenReturn("name");
        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":112, \"lon\":110}", LinkedTreeMap.class));
        when(storage.getCity()).thenReturn((HashMap<String, Object>) gson.fromJson("{\"name\": \"name\", \"coord\": {\"lat\":112, \"lon\":110} }", HashMap.class));
        ForecastReport report = parser.getForecastReport();
        assertEquals(report.countryCode, "code");
    }


    @Test
    public void testIfBuilderAsksForReportingAnswer() {

    }



}
