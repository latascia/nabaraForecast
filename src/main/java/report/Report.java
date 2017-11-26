package report;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 * Created by Nata on 08.10.17.
 */
public class Report {

    public String cityName = "default";
    public String coordinates = "default";
    public String countryCode = "default";

    public Report(String cityName, String countryCode) {
        this.cityName = cityName;
        this.countryCode = countryCode;
    }

}
