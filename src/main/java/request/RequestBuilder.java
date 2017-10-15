package request;

import http_connection.HttpConnection;
import json_parser.JSONparser;
import report.CurrentWeather;
import report.Forecast;
import url_link.RequestType;
import url_link.UrlLinkGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Nata on 27.09.17.
 */
public class RequestBuilder {
    public static Forecast getForecast() {
        String cityName = "Tallinn", countryCode = "EE";
        Forecast report = new Forecast(cityName, countryCode);

        String url = UrlLinkGenerator.generateUrlByCityNameAndCountryCode(RequestType.FORECAST, cityName, countryCode);
        StringBuilder contentGatherer = new StringBuilder();
        // sth is wrong with connection!!!!!!!!!!!!! Try to find out!!!!!!!
        try {
            HttpURLConnection con = HttpConnection.openConnection(url);
            con.connect();
            BufferedReader stream = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while (stream.ready()) {
                contentGatherer.append(stream.readLine());
            }
        } catch (IOException e) {
            System.out.println("Can't open connection!");
        }
        String content = contentGatherer.toString();
        if (content.equals("")) {
            System.out.println("Can't read content!");
        }

        JSONparser.parseJsonForForecast(content, report);

        System.out.println("Maximum temperature is " + report.getMaximumTemperature());
        System.out.println("Minimum temperature is " + report.getMinimumTemperature());
        System.out.println("Coordinates are " + report.getCoordinates());
        System.out.println("And this was the weather of city " + report.getCityName());
        return report;
    }
    public static CurrentWeather getCurrentWeather() {
        return null;
    }
}
