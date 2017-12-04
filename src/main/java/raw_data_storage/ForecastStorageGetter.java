package raw_data_storage;

import exceptions.CannotReadContentException;
import http_connection.HttpUtility;
import http_connection.RequestType;
import json_parser.JSONParser;
import request.Request;

import java.io.IOException;


public class ForecastStorageGetter extends StorageGetter {
    public ForecastStorageGetter(Request request) {
        super(request);
    }

    public ForecastDataStorage getForecast() {
        try {
            openConnection(RequestType.FORECAST);
            return JSONParser.parseJSONForForecast(connection.getPageContent());
        } catch (IOException | CannotReadContentException e) {
            ForecastDataStorage storage = new ForecastDataStorage();
            storage.failedToReceive = true;
            return storage;
        }
    }

}
