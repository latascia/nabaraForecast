package request;


import exceptions.FailedToReceiveReportException;
import org.junit.Before;
import org.junit.Test;
import report.FailReport;
import report.FinalReport;
import report.Report;


import static junit.framework.TestCase.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReportGetterTest {

    private RequestHandler requestHandler;
    private ReportGetter reporter;


    @Before
    public void prepareReporter() {
        requestHandler = mock(RequestHandler.class);
        reporter = new ReportGetter(requestHandler);
    }

    @Test
    public void testReportGetterAsksForReport() {
        try {
            reporter.getReport();
            verify(requestHandler).getReport();
        } catch (FailedToReceiveReportException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testThatHandlerDoNotThrowExceptionViaReportGettingWithWrongRequest() {
        try {
            given(requestHandler.getReport()).willThrow(new FailedToReceiveReportException());
            reporter.getReport();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testGetReportGivesFailReportIfCatchesException() {
        try {
            given(requestHandler.getReport()).willThrow(new FailedToReceiveReportException());
            Report report = reporter.getReport();
            assert(report instanceof FailReport);
        } catch (FailedToReceiveReportException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testGetReportGivesFinalReportIfDoesNotCatchException() {
        try {
            when(requestHandler.getReport()).thenReturn(new FinalReport());
            Report report = reporter.getReport();
            assert(report instanceof FinalReport);
        } catch (FailedToReceiveReportException e) {
            e.printStackTrace();
        }

    }

}
