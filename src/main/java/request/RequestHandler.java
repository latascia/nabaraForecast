package request;

import exceptions.FailedToReceiveReportException;
import exceptions.ReportsDoNotMatchException;
import raw_data_storage.CurrentWeatherDataStorage;
import raw_data_storage.CurrentWeatherStorageGetter;
import raw_data_storage.ForecastDataStorage;
import raw_data_storage.ForecastStorageGetter;
import report.FinalReport;
import report.StoragesToReportCombiner;


public class RequestHandler {
    private final Request request;


    public RequestHandler(Request request) {
        this.request = request;
    }

    public FinalReport getReport() throws FailedToReceiveReportException {
        CurrentWeatherDataStorage current = new CurrentWeatherStorageGetter(request).getCurrentWeather();
        ForecastDataStorage forecast = new ForecastStorageGetter(request).getForecast();
        StoragesToReportCombiner combiner = new StoragesToReportCombiner(forecast, current);
        return combiner.getReport();
    }
}