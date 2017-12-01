package report;


import com.google.gson.annotations.SerializedName;

public class FinalReport implements Report{
    @SerializedName("city")
    public String cityName;
    public String coordinates;
    @SerializedName("minimum temperature")
    public double minTemperatureInKelvin;
    @SerializedName("maximum temperature")
    public double maxTemperatureInKelvin;
    @SerializedName("current temperature")
    public double currentTemperature;
}
