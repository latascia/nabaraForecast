package console_input_runner;


import output_writer.OutputHandler;
import output_writer.OutputWriter;
import report.Report;
import request.ReportGetter;
import request.Request;
import request.RequestHandler;


class ConsoleDataHandler {

    private ConsoleInputGetter inputGetter;

    ConsoleDataHandler(ConsoleInputGetter inputGetter) {
        this.inputGetter = inputGetter;
        runHandler();
    }


    private void runHandler() {
        Request request = inputGetter.getRequestFromConsole();
        ReportGetter reporter = new ReportGetter(new RequestHandler(request));
        Report report = reporter.getReport();
        OutputHandler output = new OutputHandler(report, request);
        output.runWriter(new OutputWriter());
    }
}
