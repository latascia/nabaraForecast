package json_parser;

import raw_data_storage.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class JSONParser {
    public static ForecastDataStorage parseJSONForForecast(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, ForecastDataStorage.class);
    }

    public static CurrentWeatherDataStorage parseJSONForCurrentWeather(String json) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, CurrentWeatherDataStorage.class);
    }
}
