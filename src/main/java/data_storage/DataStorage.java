package data_storage;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;

/**
 * Created by Nata on 31.10.17.
 */
public class DataStorage {

    private LinkedTreeMap<String, Float> coord;
    private String name;
    private String cod;

    public LinkedTreeMap<String, Float> getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }

    public void setCoord(LinkedTreeMap<String, Float> coord) {
        this.coord = coord;
    }

    public void setName(String name) {
        this.name = name;
    }
}
