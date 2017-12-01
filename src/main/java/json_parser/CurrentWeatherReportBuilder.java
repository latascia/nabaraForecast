package json_parser;

import raw_data_storage.CurrentWeatherDataStorage;
import report.FinalReport;


public class CurrentWeatherReportBuilder  {

    private final FinalReport report;
    private CurrentWeatherDataStorage storage;

    public CurrentWeatherReportBuilder(CurrentWeatherDataStorage storage, FinalReport report) {
        this.report = report;
        this.storage = storage;
    }

    private double getCurrentTemperature() {
        return Double.parseDouble(storage.getMain().get("temp").toString());
    }

    public void addCurrentWeather() {
        report.currentTemperature = getCurrentTemperature();
    }
}
