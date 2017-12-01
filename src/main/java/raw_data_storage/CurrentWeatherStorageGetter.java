package raw_data_storage;

import exceptions.CannotReadContentException;
import http_connection.RequestType;
import json_parser.JSONParser;
import request.Request;

import java.io.IOException;

public class CurrentWeatherStorageGetter extends StorageGetter {

    public CurrentWeatherStorageGetter(Request request) {
        super(request);
    }

    public CurrentWeatherDataStorage getCurrentWeather() {
        try {
            openConnection(RequestType.CURRENT_WEATHER);
            return JSONParser.parseJSONForCurrentWeather(connection.getPageContent());
        } catch (IOException | CannotReadContentException e) {
            CurrentWeatherDataStorage storage = new CurrentWeatherDataStorage();
            storage.failedToReceive = true;
            return storage;
        }
    }
}
