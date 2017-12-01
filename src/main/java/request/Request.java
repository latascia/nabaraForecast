package request;

/**
 * Created by Nata on 06.11.17.
 */
public class Request {
    private String cityName;
    private String countryCode;

    public Request(String cityName, String countryCode) {
        this.cityName = cityName;
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
