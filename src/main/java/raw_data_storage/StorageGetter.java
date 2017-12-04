package raw_data_storage;

import http_connection.HttpUtility;
import http_connection.RequestType;
import http_connection.UrlLinkGenerator;
import request.Request;

import java.io.IOException;

class StorageGetter {
    HttpUtility connection;

    private Request request;

    StorageGetter(Request request) {
        this.request = request;
    }

    //test
    void openConnection(RequestType type) throws IOException {
        String url = UrlLinkGenerator.generateUrlByCityNameAndCountryCode(type, request.getCityName(), request.getCountryCode());
        connection = new HttpUtility(url);
    }

}
