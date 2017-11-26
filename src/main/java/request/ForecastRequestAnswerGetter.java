package request;

import http_connection.RequestType;
import json_parser.ForecastReportBuilder;
import json_parser.JSONParser;
import report.ForecastReport;

import java.util.Optional;

/**
 * Created by Nata on 03.11.17.
 */
public class ForecastRequestAnswerGetter extends RequestAnswerGetter {
    public ForecastRequestAnswerGetter(String cityName, String countryCode) {
        super(cityName, countryCode);
    }

    public Optional<ForecastReport> getForecast() {
        super.openConnection(RequestType.FORECAST);
        if (super.connection == null) {
            return Optional.empty();
        }
        ForecastReportBuilder reportBuilder =  new ForecastReportBuilder(JSONParser.parseJSONForForecast(connection.getPageContent()));
        return Optional.of(reportBuilder.getForecastReport());
    }

    public void printOutGotInformation() {
        Optional<ForecastReport> reportOptional = getForecast();
        if (!reportOptional.isPresent()) {
            System.out.println("We are sorry, but we cannot resolve needed information.");
        } else {
            ForecastReport report = reportOptional.get();
            System.out.println("This is the forecast for city " + report.cityName);
            System.out.println("Coordinates of the city: " + report.coordinates);
            System.out.println("Minimum temperature in three days: " + report.minTemperatureInKelvin);
            System.out.println("Maximum temperature in three days: " + report.maxTemperatureInKelvin);
        }
    }
}
