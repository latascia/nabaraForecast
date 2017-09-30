package report;

/**
 * Created by Nata on 27.09.17.
 */
public interface Report {

    String getCountryCode();
    String getCityName();
    String getCoordinates();
    void setCoordinates(String latitude, String longitude);
}
