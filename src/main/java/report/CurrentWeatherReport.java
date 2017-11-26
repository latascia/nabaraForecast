package report;

import java.util.regex.Pattern;

/**
 * Created by Nata on 27.09.17.
 */
public class CurrentWeatherReport extends Report{
    public double currentTemperature;

    public CurrentWeatherReport(String cityName, String countryCode) {
     super(cityName, countryCode);
    }

}
