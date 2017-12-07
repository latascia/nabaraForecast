package raw_data_storage;

import report.StoragesToReportCombiner;

import java.util.HashMap;

/**
 * Created by Nata on 31.10.17.
 */
public class ForecastDataStorage extends Storage {

    private Prediction[] list;
    private City city;

    public Prediction[] getList() {
        return list;
    }

    public String getCityName() {
        return city.name;
    }
    public HashMap<String, Float> getCoord() {return city.coord;}
}
