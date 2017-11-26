package data_storage;

import java.util.HashMap;

/**
 * Created by Nata on 31.10.17.
 */
public class CurrentWeatherDataStorage extends DataStorage {

    private HashMap<String, Object> main;

    public HashMap<String, Object> getMain() {
        return main;
    }
}
