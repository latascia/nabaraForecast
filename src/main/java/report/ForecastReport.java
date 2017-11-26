package report;


import java.text.DecimalFormat;

/**
 * Created by Nata on 27.09.17.
 */
public class ForecastReport extends Report {

    public double minTemperatureInKelvin;
    public double maxTemperatureInKelvin;

    public ForecastReport(String cityName, String countryCode) {
        super(cityName, countryCode);
    }

}
