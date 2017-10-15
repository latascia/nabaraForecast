package report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
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

    public void setCoordinates(double latitude, double longitude) {
        NumberFormat formatter = new DecimalFormat("#000.00");
        latitude = (Math.floor(latitude * 100)) / 100;
        longitude = (Math.floor(longitude * 100)) / 100;
        coordinates = String.format("%s:%s", formatter.format(latitude), formatter.format(longitude));
    }

    public String getCoordinates() {
        return coordinates;
    }
}
