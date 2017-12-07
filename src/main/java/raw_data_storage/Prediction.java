package raw_data_storage;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Created by Nata on 07.12.17.
 */
public class Prediction {
    private HashMap<String, Float>  main;
    @SerializedName("dt_txt")
    private String dateTime;

    public HashMap<String, Float> getMain() {
        return main;
    }

    public String getDateTime() {
        return dateTime;
    }
}
