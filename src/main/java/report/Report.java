package report;

import java.util.regex.Pattern;

/**
 * Created by Nata on 08.10.17.
 */
public class Report {

    private String cityName = "default";
    private String coordinates = "default";
    private String countryCode = "default";

    public Report(String cityName, String countryCode) {
        this.cityName = cityName;
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCoordinates(String latitude, String longitude) {
        if (latitude == null || longitude == null) {
            return;
        }
        latitude = latitude.split(Pattern.quote("."))[0];
        longitude = longitude.split(Pattern.quote("."))[0];
        latitude = latitude.startsWith("-") ? "-" +  ("000" + latitude).substring(latitude.length()) : ("000" + latitude).substring(latitude.length());
        longitude = longitude.startsWith("-") ? "-" + ("000" + longitude).substring(longitude.length()) : ("000" + longitude).substring(longitude.length());
        coordinates = String.format("%s:%s", latitude, longitude);
    }

    public String getCoordinates() {
        return coordinates;
    }
}
