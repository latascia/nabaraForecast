package raw_data_storage;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;


public class CurrentWeatherDataStorage extends Storage {

    private HashMap<String, Object> main;
    private String name;

    public HashMap<String, Object> getMain() {return main;}
    public String getCityName() {
        return name;
    }


}
