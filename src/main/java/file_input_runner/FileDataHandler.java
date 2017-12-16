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
import java.util.Optional;


class FileDataHandler {

    private void writeReport(Request request) {
        ReportGetter reporter = new ReportGetter(new RequestHandler(request));
        Report report = reporter.getReport();
        OutputHandler output = new OutputHandler(report, request);
        output.runWriter(new OutputWriter());
    }

    void run(FileInputGetter inputGetter) {
        try {
            Optional<RequestList> list = inputGetter.getRequestFromFile();
            if (list.isPresent()) {
                for (Request request : list.get().requests) {
                    writeReport(request);
                }
            }
        } catch (FileNotFoundException | NullPointerException e) {
            OutputHandler outputHandler = new OutputHandler(new FailReport(), "general");
            outputHandler.runWriter(new OutputWriter());
        }
    }

}
