package json_parser;

import data_storage.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Created by Nata on 27.09.17.
 */
public class JSONParser {
    public static ForecastDataStorage parseJSONForForecast(String json) {
        Gson gson = new GsonBuilder().create();
        final ForecastDataStorage weatherStorage = gson.fromJson(json, ForecastDataStorage.class);
        return weatherStorage;
    }

    public static CurrentWeatherDataStorage parseJSONForCurrentWeather(String json) {
        Gson gson = new GsonBuilder().create();
        final CurrentWeatherDataStorage weatherStorage = gson.fromJson(json, CurrentWeatherDataStorage.class);
        return weatherStorage;
    }
}
