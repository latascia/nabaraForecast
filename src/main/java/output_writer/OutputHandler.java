package output_writer;

import com.google.gson.Gson;
import report.Report;
import request.Request;

/**
 * Created by Nata on 30.11.17.
 */
public class OutputHandler {
    private final Report report;
    private String fileId;

    public OutputHandler(Report report, Request request) {
        this.report = report;
        fileId = request.getCityName();
    }

    public OutputHandler(Report report, String id) {
        this.report = report;
        this.fileId = id;
    }

    private String getPath() {
        final String PATH_PATTERN = "output_%s.txt";
        return String.format(PATH_PATTERN, fileId);
    }
    public void runWriter() {
        OutputWriter writer = new OutputWriter();
        writer.writeToFile(getPath(), getJSON());
    }
    private String getJSON() {
        Gson gson = new Gson();
        return gson.toJson(report);
    }
}
