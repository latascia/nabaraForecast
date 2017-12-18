package output_writer;


import org.junit.Before;
import org.junit.Test;
import report.FinalReport;
import report.Report;
import request.Request;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OutputHandlerTest {

    @Test
    public void testConstructorGetRequestAsksForCityName() {
        Request request = mock(Request.class);
        new OutputHandler(new FinalReport(), request);
        verify(request).getCityName();
    }

    @Test
    public void testPathGetterThroughRequest() {
        Request request = mock(Request.class);
        when(request.getCityName()).thenReturn("DamnName");
        OutputHandler handler = new OutputHandler(mock(Report.class), request);
        String path = handler.getPath();
        assertEquals("output_DamnName.txt", path);
    }

    @Test
    public void testPathGetterThroughCityName() {
        OutputHandler handler = new OutputHandler(mock(Report.class), "DamnName");
        String path = handler.getPath();
        assertEquals("output_DamnName.txt", path);
    }


 }
