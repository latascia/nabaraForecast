package raw_data_storage;

import java.util.HashMap;

public class ForecastDataStorage extends Storage {

    private WeatherPrediction[] list;
    private City city;

    public WeatherPrediction[] getList() {
        return list;
    }

    public String getCityName() {
        return city.name;
    }
    public HashMap<String, Float> getCoord() {return city.coord;}
}
