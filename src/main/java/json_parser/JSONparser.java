package json_parser;

import report.CurrentWeather;
import report.Forecast;


/**
 * Created by Nata on 27.09.17.
 */
public class JSONparser {
    final static int THREE_DAYS_DATA_AMOUNT = 8 * 3;
    final static int CITY_DATA_STARTS_AT = 100;

    public static void parseJsonForForecast(String toParse, Forecast report) {
        int daysDataAmount = 0;
        String longitude = null, latitude = null;
        double minTemperature = 0, maxTemperature = 0;
        for (;toParse.length() > 0; toParse = toParse.substring(1)) {
            if (toParse.startsWith("\"temp_max\":")) {

                daysDataAmount++;
            }
            if (daysDataAmount >=THREE_DAYS_DATA_AMOUNT) {
                break;
            }
        }
        toParse = toParse.substring(toParse.length() - CITY_DATA_STARTS_AT);
        for (;toParse.length() > 0; toParse = toParse.substring(1)) {
            if (toParse.startsWith("\"lat\":")) {

            } else if (toParse.startsWith("\"lon\":")) {

            }
        }
        report.setCoordinates(latitude, longitude);
        report.setTemperature(maxTemperature, minTemperature);
    }

    public static void parseJsonForCurrentWeather(String toParse, CurrentWeather report) {
        String longitude = null, latitude = null;
        double currentTemp = 0;
        for (; toParse.length() > 0; toParse = toParse.substring(1)) {
            if (toParse.startsWith("\"lon\":")) {

            } else if (toParse.startsWith("\"lat\":")) {

            } else if (toParse.startsWith("\"temp\":")) {

            }
        }
        report.setCoordinates(latitude, longitude);
        report.setCurrentTemperatureKelvin(currentTemp);
    }
}
