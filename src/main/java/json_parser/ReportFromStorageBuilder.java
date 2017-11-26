package json_parser;

import data_storage.DataStorage;

/**
 * Created by Nata on 03.11.17.
 */
public class ReportFromStorageBuilder {
    private DataStorage storage;
    public ReportFromStorageBuilder(DataStorage storage) {
        this.storage = storage;
    }

    String getCityName() {
        return storage.getName();
    }

    String getCode() {
        return storage.getCod();
    }

    String getCoordinates() {
        return String.format("%.2f:%.2f", storage.getCoord().get("lat"), storage.getCoord().get("lon"));
    }
}
