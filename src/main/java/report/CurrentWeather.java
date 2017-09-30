package report;

/**
 * Created by Nata on 27.09.17.
 */
public class CurrentWeather implements Report{

    private String cityName = "default";
    private String coordinates = "default";
    private String countryCode = "default";
    private double currentTemperatureInKelvin;

    public CurrentWeather(String cityName, String countryCode) {
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
        this.coordinates = coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public double getCurrentTemperatureInKelvin() {
        return currentTemperatureInKelvin;
    }

    public void setCurrentTemperatureKelvin(double currentTemperatureKelvin) {
        this.currentTemperatureInKelvin = currentTemperatureKelvin;
    }
}
