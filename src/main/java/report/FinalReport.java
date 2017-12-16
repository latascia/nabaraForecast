package report;


import com.google.gson.annotations.SerializedName;

public class FinalReport implements Report{
    @SerializedName("city")
    String cityName;
    String coordinates;
    @SerializedName("min_temp")
    public double minTemperatureInKelvin;
    @SerializedName("max_temp")
    public double maxTemperatureInKelvin;
    @SerializedName("cur_temp")
    public double currentTemperature;
}
