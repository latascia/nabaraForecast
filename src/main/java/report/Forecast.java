package report;


/**
 * Created by Nata on 27.09.17.
 */
public class Forecast extends Report {

    private double minTemperatureInKelvin;
    private double maxTemperatureInKelvin;

    public Forecast(String cityName, String countryCode) {
        super(cityName, countryCode);
    }

    public void setTemperature(double max, double min) {
        minTemperatureInKelvin = min;
        maxTemperatureInKelvin = max;
    }

    public double getMinimumTemperature() {
        return minTemperatureInKelvin;
    }

    public double getMaximumTemperature() {
        return maxTemperatureInKelvin;
    }
}
