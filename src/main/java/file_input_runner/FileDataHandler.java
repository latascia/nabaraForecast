package file_input_runner;

import exceptions.FailedToReceiveReportException;
import output_writer.OutputHandler;
import output_writer.OutputWriter;
import report.FailReport;
import report.Report;
import request.ReportGetter;
import request.Request;
import request.RequestHandler;
import request.RequestList;

import java.io.FileNotFoundException;


class FileDataHandler {

    private void writeReport(Request request) {
        ReportGetter reporter = new ReportGetter(new RequestHandler(request));
        Report report = reporter.getReport();
        OutputHandler output = new OutputHandler(report, request);
        output.runWriter(new OutputWriter());
    }

    void run(FileInputGetter inputGetter) {
        try {
            RequestList list = inputGetter.getRequestFromFile();
            for (Request request : list.requests) {
                writeReport(request);
            }
        } catch (FileNotFoundException e) {
            OutputHandler outputHandler = new OutputHandler(new FailReport(), "general");
            outputHandler.runWriter(new OutputWriter());
        }
    }

}
