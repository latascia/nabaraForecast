package file_input_runner;

import exceptions.FailedToReceiveReportException;
import output_writer.OutputHandler;
import report.FailReport;
import report.Report;
import request.Request;
import request.RequestHandler;
import request.RequestList;

import java.io.FileNotFoundException;

/**
 * Created by Nata on 01.12.17.
 */
public class FileDataHandler {

    private static Report getReport(Request request) {
        try {
            RequestHandler handler = new RequestHandler(request);
            return  handler.getReport();
        } catch (FailedToReceiveReportException e) {
            return new FailReport();
        }
    }

    private static void writeReport(Request request) {
        Report report = getReport(request);
        OutputHandler output = new OutputHandler(report, request);
        output.runWriter();
    }

    public static void main(String[] args) {
        try {
            FileInputGetter inputGetter = new FileInputGetter();
            RequestList list = inputGetter.getRequestFromFile();
            System.out.println("was");
            for (Request request : list.requests) {
                System.out.println("here");
                writeReport(request);
            }
        } catch (FileNotFoundException e) {
            System.out.println("nowGotThere");
            OutputHandler outputHandler = new OutputHandler(new FailReport(), "general");
            outputHandler.runWriter();
        }
    }
}
