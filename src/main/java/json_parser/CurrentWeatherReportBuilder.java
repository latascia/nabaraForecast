package json_parser;

import data_storage.CurrentWeatherDataStorage;
import report.CurrentWeatherReport;

/**
 * Created by Nata on 02.11.17.
 */
public class CurrentWeatherReportBuilder extends ReportFromStorageBuilder {

    private CurrentWeatherDataStorage storage;

    public CurrentWeatherReportBuilder(CurrentWeatherDataStorage storage) {
        super(storage);
        this.storage = storage;
    }

    private double getCurrentTemperature() {
        return Double.parseDouble(storage.getMain().get("temp").toString());
    }
    public CurrentWeatherReport getCurrentWeatherReport() {
        CurrentWeatherReport report = new CurrentWeatherReport(super.getCityName(), super.getCode());
        report.coordinates = super.getCoordinates();
        report.currentTemperature = getCurrentTemperature();
        return report;
    }
}
