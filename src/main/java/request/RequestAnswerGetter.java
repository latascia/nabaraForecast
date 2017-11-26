package request;

import http_connection.HttpUtility;
import http_connection.RequestType;
import http_connection.UrlLinkGenerator;

import java.io.IOException;

/**
 * Created by Nata on 03.11.17.
 */
public class RequestAnswerGetter {
    HttpUtility connection;

    Request request = new Request();

    public RequestAnswerGetter(String cityName, String countryCode) {
        request.cityName = cityName;
        request.countryCode = countryCode;
    }

    void openConnection(RequestType type) {
        try {
            String url = UrlLinkGenerator.generateUrlByCityNameAndCountryCode(type, request.cityName, request.countryCode);
            connection = new HttpUtility(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
