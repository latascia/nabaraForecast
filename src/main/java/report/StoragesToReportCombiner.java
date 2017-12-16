package report;

import exceptions.CannotReadContentException;
import exceptions.FailedToReceiveReportException;
import exceptions.ReportsDoNotMatchException;
import json_parser.CurrentWeatherReportBuilder;
import json_parser.ForecastReportBuilder;
import raw_data_storage.CurrentWeatherDataStorage;
import raw_data_storage.ForecastDataStorage;


public class StoragesToReportCombiner {

    private final ForecastDataStorage forecast;
    private final CurrentWeatherDataStorage currentWeather;
    private FinalReport report = new FinalReport();

    public StoragesToReportCombiner(ForecastDataStorage forecast, CurrentWeatherDataStorage currentWeather) {
        this.forecast = forecast;
        this.currentWeather = currentWeather;
    }

    void checkIfMessageReceived() throws CannotReadContentException {
        if (forecast.isFailedToReceive() | currentWeather.isFailedToReceive()) {
            throw new CannotReadContentException();
        }
    }
    void checkIfCombinationIsValid() throws ReportsDoNotMatchException {
        if(!forecast.getCityName().equals(currentWeather.getCityName())) {
            throw new ReportsDoNotMatchException();
        }
    }

    String formatCoordinates() {
        return String.format("%.2f:%.2f", forecast.getCoord().get("lat"), forecast.getCoord().get("lon"));
    }

    private void addWeatherInfo() {
        CurrentWeatherReportBuilder cWBuilder = new CurrentWeatherReportBuilder(currentWeather, report);
        cWBuilder.addCurrentWeather();
        ForecastReportBuilder fBuilder = new ForecastReportBuilder(forecast, report);
        fBuilder.addForecast();
    }

    public FinalReport getReport() throws FailedToReceiveReportException {
        checkIfMessageReceived();
        checkIfCombinationIsValid();

        report.cityName = forecast.getCityName();
        report.coordinates = formatCoordinates();
        addWeatherInfo();

        return report;
    }
}
