package json_parser;

import report.CurrentWeather;
import report.Forecast;


/**
 * Created by Nata on 27.09.17.
 */
public class JSONparser {
    final static int THREE_DAYS_DATA_AMOUNT = 8 * 3;
    final static int FOOTER = 60;

    private static double findInJson(String json, String toFind) {
        json = json.substring(toFind.length());
        StringBuilder answer = new StringBuilder();
        while (Character.isDigit(json.charAt(0)) || json.charAt(0) == '.' || json.charAt(0) == '-') {
            answer.append(json.charAt(0));
            json = json.substring(1);
        }
        System.out.println(answer.toString());
        return Double.parseDouble(answer.toString());
    }

    public static void parseJsonForForecast(String toParse, Forecast report) {
        double longitude = Double.NaN, latitude = Double.NaN;
        double minTemperature = Double.MAX_VALUE, maxTemperature = Double.MIN_VALUE;
        for (int daysDataAmount = 0; daysDataAmount < THREE_DAYS_DATA_AMOUNT && toParse.length() > FOOTER; toParse = toParse.substring(1)) {
            if (toParse.startsWith("\"temp_min\":")) {
                double toCompare = findInJson(toParse, "\"temp_min\":");
                if (toCompare < minTemperature) {
                    minTemperature = toCompare;
                }
            }else if (toParse.startsWith("\"temp_max\":")) {
                double toCompare = findInJson(toParse, "\"temp_max\":");
                if (toCompare > maxTemperature) {
                    maxTemperature = toCompare;
                }
                daysDataAmount++;
            }
        }

        for (;toParse.length() > 0; toParse = toParse.substring(1)) {
            if (toParse.startsWith("\"lat\":")) {
                latitude = findInJson(toParse, "\"lat\":");
                System.out.println(latitude);
            } else if (toParse.startsWith("\"lon\":")) {
                longitude = findInJson(toParse, "\"lon\":");
                System.out.println(longitude);
            }
        }
        report.setCoordinates(latitude, longitude);
        report.setTemperature(maxTemperature, minTemperature);
    }

    public static void parseJsonForCurrentWeather(String toParse, CurrentWeather report) {
        double longitude = Double.NaN, latitude = Double.NaN;
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
