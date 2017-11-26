package http_connection;

import http_connection.RequestType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Nata on 24.09.17.
 */
public class UrlLinkGenerator {


    private static final String API_KEY = "e8f64f746b108351d35e396af44d3ae0";
    private static final Set<String> ISO_COUNTRIES = new HashSet<String>
            (Arrays.asList(Locale.getISOCountries()));


    public static boolean isCountryCodeValid(String countryCode) throws NullPointerException {
        return ISO_COUNTRIES.contains(countryCode.toUpperCase());
    }

    public static String generateUrlByCityName(RequestType urlBeginning, String cityName) {
        if (cityName == null || cityName.equals("")) {
            return null;
        }
        String url = "";
        switch (urlBeginning) {
            case CURRENT_WEATHER:
                url = "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
                break;
            case FORECAST:
                url = "https://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s";
        }
        return String.format(url, cityName, API_KEY);
    }

    public static String generateUrlByCityNameAndCountryCode(RequestType urlBeginning, String cityName, String countryCode) {
        if (cityName == null || cityName.equals("")) {
            return null;
        }
        try {
            if (!isCountryCodeValid(countryCode)) {
                return generateUrlByCityName(urlBeginning, cityName);
            }
        } catch (NullPointerException e) {
            return generateUrlByCityName(urlBeginning, cityName);
        }
        String url = "";
        switch (urlBeginning) {
            case CURRENT_WEATHER:
                url = "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s";
                break;
            case FORECAST:
                url = "https://api.openweathermap.org/data/2.5/forecast?q=%s,%s&appid=%s";
        }
        return String.format(url, cityName, countryCode, API_KEY);
    }

    public static String generateUrlByGeoCoordinates(RequestType urlBeginning, int lat, int lon) {
        String url = "";
        switch (urlBeginning) {
            case CURRENT_WEATHER:
                url = "https://api.openweathermap.org/data/2.5/weather?lat=%d&lon=%d&appid=%s";
                break;
            case FORECAST:
                url = "https://api.openweathermap.org/data/2.5/forecast?lat=%d&lon=%d&appid=%s";
                break;
        }
        return String.format(url, lat, lon, API_KEY);
    }
}
