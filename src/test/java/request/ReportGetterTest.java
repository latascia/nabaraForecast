package request;


import exceptions.FailedToReceiveReportException;
import org.junit.Test;
import report.FailReport;
import report.FinalReport;
import report.Report;
import request.ReportGetter;
import request.RequestHandler;

import static junit.framework.TestCase.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportGetterTest {

    @Test
    public void testThatHandlerDoNotThrowExceptionViaReportGettingWithWrongRequest() {
        try {
            RequestHandler requestHandler = mock(RequestHandler.class);
            given(requestHandler.getReport()).willThrow(new FailedToReceiveReportException());
            ReportGetter reporter = new ReportGetter(requestHandler);
            reporter.getReport();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testGetReportGivesFailReportIfCatchesException() {
        try {
            RequestHandler requestHandler = mock(RequestHandler.class);
            given(requestHandler.getReport()).willThrow(new FailedToReceiveReportException());
            ReportGetter reporter = new ReportGetter(requestHandler);
            Report report = reporter.getReport();
            assert(report instanceof FailReport);
        } catch (FailedToReceiveReportException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetReportGivesFinalReportIfDoesNotCatchException() {
        try {
            RequestHandler requestHandler = mock(RequestHandler.class);
            ReportGetter reporter = new ReportGetter(requestHandler);
            when(requestHandler.getReport()).thenReturn(new FinalReport());
            Report report = reporter.getReport();
            assert(report instanceof FinalReport);
        } catch (FailedToReceiveReportException e) {
            e.printStackTrace();
        }

    }

}
