package output_writer;

import com.google.gson.Gson;
import report.Report;
import request.Request;


public class OutputHandler {
    private final Report report;
    private String fileId;

    public OutputHandler(Report report, Request request) {
        this.report = report;
        fileId = request.getCityName();
    }

    public OutputHandler(Report report, String cityName) {
        this.report = report;
        this.fileId = cityName;
    }

    String getPath() {
        final String PATH_PATTERN = "output_%s.txt";
        return String.format(PATH_PATTERN, fileId);
    }
    //
    public void runWriter(OutputWriter writer) {
        writer.writeToFile(getPath(), getJSON());
    }

    private String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(report);
    }
}
