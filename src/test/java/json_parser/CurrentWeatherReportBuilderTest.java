package json_parser;


import org.junit.Before;
import org.junit.Test;
import raw_data_storage.CurrentWeatherDataStorage;
import report.FinalReport;


import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CurrentWeatherReportBuilderTest {
    private CurrentWeatherDataStorage storage;
    private CurrentWeatherReportBuilder builder;

    @Before
    public void prepare() {
        FinalReport report = mock(FinalReport.class);
        storage = mock(CurrentWeatherDataStorage.class);
        builder = new CurrentWeatherReportBuilder(storage, report);
    }

    @Test
    public void testIfWritingTemperatureBuilderAsksForMain() {
        HashMap<String, Object> temp = new HashMap<>();
        temp.put("temp", 235);
        when(storage.getMain()).thenReturn(temp);
        builder.getCurrentTemperature();
        verify(storage).getMain();
    }

}
