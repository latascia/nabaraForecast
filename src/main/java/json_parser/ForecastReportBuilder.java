package json_parser;

import com.google.gson.internal.LinkedTreeMap;
import data_storage.ForecastDataStorage;
import report.ForecastReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Created by Nata on 02.11.17.
 */
public class ForecastReportBuilder extends ReportFromStorageBuilder {
    private ForecastDataStorage storage;

    double min_temp = Double.MAX_VALUE;
    double max_temp = -Double.MAX_VALUE;

    public ForecastReportBuilder(ForecastDataStorage storage) {
        super(storage);
        this.storage = storage;
    }

    private void setName() {
        storage.setName(storage.getCity().get("name").toString());
    }
    private void setCoordinates() {
        storage.setCoord((LinkedTreeMap<String, Float>) storage.getCity().get("coord"));
    }

    private int countNeededValuesAmount(LocalDateTime time) {
        final int HOURS_IN_DAY = 24;
        final int INTERVAL_BETWEEN_VALUES  = 3;
        return (HOURS_IN_DAY - time.getHour() - 1) / INTERVAL_BETWEEN_VALUES + 2 * (HOURS_IN_DAY / INTERVAL_BETWEEN_VALUES);
    }

    private void findTemperatureExtremums() {
        LocalDateTime time = LocalDateTime.parse(storage.getList()[0].get("dt_txt").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        for (int i = 0; i < countNeededValuesAmount(time); i++) {
            changeMinimum(((LinkedTreeMap<String, Double>) storage.getList()[i].get("main")).get("temp_min"));
            changeMaximum(((LinkedTreeMap<String, Double>) storage.getList()[i].get("main")).get("temp_max"));
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

    public ForecastReport getForecastReport() {
        findTemperatureExtremums();
        setName();
        setCoordinates();
        ForecastReport report = new ForecastReport(super.getCityName(), super.getCode());
        report.coordinates = super.getCoordinates();
        report.maxTemperatureInKelvin = max_temp;
        report.minTemperatureInKelvin = min_temp;
        return report;
    }
}
