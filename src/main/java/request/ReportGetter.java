package request;

import exceptions.FailedToReceiveReportException;
import report.FailReport;
import report.Report;


public class ReportGetter {
    private RequestHandler handler;
    public ReportGetter(RequestHandler handler) {
        this.handler = handler;
    }

    public Report getReport() {
        try {
            return  handler.getReport();
        } catch (FailedToReceiveReportException e) {
            return new FailReport();
        }
    }
}
