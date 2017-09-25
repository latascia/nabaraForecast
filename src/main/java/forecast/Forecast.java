package forecast;

import java.util.ArrayList;

/**
 * Created by Nata on 24.09.17.
 */
public class Forecast {
    private String name;
    private String coordinates;
    private int maximumTemperature;
    private int minTemperature;
    private String currentTemrature;
    private ArrayList threeDaysArray;

    public Forecast(String data) {
    }

    public String getName() {
        return name;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public int getMaxTemperature(ArrayList temperatureData) {
        return maximumTemperature;
    }

    public int getMinTemperature(ArrayList temperatureData) {
        return minTemperature;
    }

    public String getCurrentTemrature() {
        return currentTemrature;
    }

    public ArrayList getThreeDaysTemperature() {
        return threeDaysArray;
    }
}
