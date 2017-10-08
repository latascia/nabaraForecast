package report;

import java.util.regex.Pattern;

/**
 * Created by Nata on 27.09.17.
 */
public class CurrentWeather extends Report{
    private double currentTemperatureInKelvin;

    public CurrentWeather(String cityName, String countryCode) {
     super(cityName, countryCode);
    }

    public double getCurrentTemperatureInKelvin() {
        return currentTemperatureInKelvin;
    }

    public void setCurrentTemperatureKelvin(double currentTemperatureKelvin) {
        this.currentTemperatureInKelvin = currentTemperatureKelvin;
    }
}
