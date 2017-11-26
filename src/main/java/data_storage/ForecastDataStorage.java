package data_storage;

import java.util.HashMap;

/**
 * Created by Nata on 31.10.17.
 */
public class ForecastDataStorage extends DataStorage {

    private HashMap<String, WeatherInfo>[] list;
    private HashMap<String, Object> city;

    public HashMap<String, WeatherInfo>[] getList() {
        return list;
    }

    public HashMap<String, Object> getCity() {
        return city;
    }
}
