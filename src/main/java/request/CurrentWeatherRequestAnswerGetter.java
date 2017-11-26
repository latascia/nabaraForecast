package request;

import http_connection.RequestType;
import json_parser.CurrentWeatherReportBuilder;
import json_parser.JSONParser;
import report.CurrentWeatherReport;

import java.util.Optional;

/**
 * Created by Nata on 27.09.17.
 */
public class CurrentWeatherRequestAnswerGetter extends RequestAnswerGetter {

    public CurrentWeatherRequestAnswerGetter(String cityName, String countryCode) {
        super(cityName, countryCode);
    }

    public Optional<CurrentWeatherReport> getCurrentWeather() {
        openConnection(RequestType.CURRENT_WEATHER);
        if (connection == null) {
            return Optional.empty();
        }
        CurrentWeatherReportBuilder reportBuilder =  new CurrentWeatherReportBuilder(JSONParser.parseJSONForCurrentWeather(connection.getPageContent()));
        return Optional.ofNullable(reportBuilder.getCurrentWeatherReport());
    }

    public void printOutGotInformation() {
        Optional<CurrentWeatherReport> reportOptional = getCurrentWeather();
        if (!reportOptional.isPresent()) {
            System.out.println("We are sorry, but we cannot resolve needed information.");
        } else {
            CurrentWeatherReport report = reportOptional.get();
            System.out.println("This is the current weather report for city " + report.cityName);
            System.out.println("Coordinates of the city: " + report.coordinates);
            System.out.println("Current Temperature: " + report.currentTemperature);
        }
    }
}
