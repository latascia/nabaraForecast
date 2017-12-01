package raw_data_storage;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

/**
 * Created by Nata on 31.10.17.
 */
public class CurrentWeatherDataStorage extends Storage {

    private HashMap<String, Object> main;
    public HashMap<String, Object> getMain() {
        return main;
    }
    private LinkedTreeMap<String, Float> coord;
    private String name;

    public LinkedTreeMap<String, Float> getCoord() {
        return coord;
    }

    public String getCityName() {
        return name;
    }


}
