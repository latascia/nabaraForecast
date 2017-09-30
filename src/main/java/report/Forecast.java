package report;

/**
 * Created by Nata on 27.09.17.
 */
public class Forecast implements Report {


    private String cityName = "default";
    private String coordinates = "default";
    private String countryCode = "default";
    private double minTemperatureInKelvin;
    private double maxTemperatureInKelvin;

    public Forecast(String cityName, String countryCode) {
        this.cityName = cityName;
        this.countryCode = countryCode;
    }
    public String getCountryCode() {
        return null;
    }

    public String getCityName() {
        return null;
    }

    public String getCoordinates() {
        return null;
    }

    public void setTemperature(double max, double min) {
        minTemperatureInKelvin = min;
        maxTemperatureInKelvin = max;
    }

    public void setCoordinates(String latitude, String longitude) {
    }

    public double getMinimumTemperature() {
        return minTemperatureInKelvin;
    }

    public double getMaximumTemperature() {
        return maxTemperatureInKelvin;
    }
}
