package json_parser;

import com.google.gson.internal.LinkedTreeMap;
import raw_data_storage.ForecastDataStorage;
import report.FinalReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class ForecastReportBuilder {
    private FinalReport report;
    private ForecastDataStorage storage;

    double min_temp = Double.MAX_VALUE;
    double max_temp = -Double.MAX_VALUE;

    public ForecastReportBuilder(ForecastDataStorage storage, FinalReport report) {
        this.storage = storage;
        this.report = report;
    }

    int countNeededValuesAmount(LocalDateTime time) {
        final int HOURS_IN_DAY = 24;
        final int INTERVAL_BETWEEN_VALUES  = 3;
        return (HOURS_IN_DAY - time.getHour() - 1) / INTERVAL_BETWEEN_VALUES + 2 * (HOURS_IN_DAY / INTERVAL_BETWEEN_VALUES);
    }

    private void findTemperatureExtremums() {
        LocalDateTime time = LocalDateTime.parse(storage.getList()[0].getDateTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        for (int i = 0; i < countNeededValuesAmount(time); i++) {
            changeMinimum(storage.getList()[i].getMain().get("temp_min"));
            changeMaximum(storage.getList()[i].getMain().get("temp_max"));
        }
    }

    void changeMinimum(double temp) {
        if (temp < min_temp) {
            min_temp = temp;
        }
    }

    void changeMaximum(double temp) {
        if (temp > max_temp) {
            max_temp = temp;
        }
    }

    public void addForecast() {
        findTemperatureExtremums();
        report.maxTemperatureInKelvin = max_temp;
        report.minTemperatureInKelvin = min_temp;
    }
}
