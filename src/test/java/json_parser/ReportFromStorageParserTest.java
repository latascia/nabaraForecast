package json_parser;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.junit.Before;
import org.junit.Test;
import report.FinalReport;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Nata on 11.11.17.
 */
public class ReportFromStorageParserTest {
//    //TODO 1. mock. 2. assert coordinates
//    private DataStorage storage;
//    private WasReportFromStorageIsMUSOR parser;
//
//    @Before
//    public void prepareObjects() {
//        storage = mock(DataStorage.class);
//        parser = new WasReportFromStorageIsMUSOR(storage, new FinalReport());
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenLonLatArePositiveTwoSignsAfterComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":0.12, \"lon\":11.00}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "0,12:11,00");
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenPositiveLonNegativeLatTwoSignsAfterComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":-0.12, \"lon\":11.00}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "-0,12:11,00");
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenNegativeLonPositiveLatTwoSignsAfterComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":0.12, \"lon\":-11.00}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "0,12:-11,00");
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenLonLatArePositiveNoSignsAfterComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":0, \"lon\":11}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "0,00:11,00");
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenLonLatArePositiveThreeSignsAfterComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":0.122, \"lon\":11.003}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "0,12:11,00");
//    }
//
//    @Test
//    public void testIfBuilderFormatsCoordinatesThenLonLatArePositiveThreeSignsBeforeComa() {
//        Gson gson = new Gson();
//        when(storage.getCoord()).thenReturn((LinkedTreeMap<String, Float>) gson.fromJson("{\"lat\":112, \"lon\":110}", LinkedTreeMap.class));
//        assertEquals(parser.getCoordinates(), "112,00:110,00");
//    }
//
//    @Test
//    public void testIfBuilderGivesNameFromStorage() {
//        String name = "Paris";
//        when(storage.getName()).thenReturn(name);
//        assertEquals(parser.getCityName(), name);
//    }
//
//    @Test
//    public void testIfBuilderGivesCodeFromStorage() {
//        String code = "JS";
//        when(storage.getCod()).thenReturn(code);
//        assertEquals(parser.getCode(), code);
//    }
}
