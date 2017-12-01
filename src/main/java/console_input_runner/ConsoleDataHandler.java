package console_input_runner;

import exceptions.FailedToReceiveReportException;
import exceptions.ReportsDoNotMatchException;
import output_writer.OutputHandler;
import report.FailReport;
import report.Report;
import request.Request;
import request.RequestHandler;


public class ConsoleDataHandler {

    private static Request request;

    private static Report getReport() {
        try {
            RequestHandler handler = new RequestHandler(request);
            return  handler.getReport();
        } catch (FailedToReceiveReportException e) {
            return new FailReport();
        }
    }

    public static void main(String[] args) {
        ConsoleInputGetter inputGetter = new ConsoleInputGetter();
        request = inputGetter.getRequestFromConsole();
        Report report = getReport();
        OutputHandler output = new OutputHandler(report, request);
        output.runWriter();
    }
}
