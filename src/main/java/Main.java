import request.CurrentWeatherRequestAnswerGetter;
import request.ForecastRequestAnswerGetter;

/**
 * Created by Nata on 28.09.17.
 */
public class Main {
    public static void main(String[] args) {
        CurrentWeatherRequestAnswerGetter curRequest = new CurrentWeatherRequestAnswerGetter("Tallinn", "EE");
        curRequest.getCurrentWeather();
        curRequest.printOutGotInformation();
        ForecastRequestAnswerGetter forRequest = new ForecastRequestAnswerGetter("Tallinn", "EE");
        forRequest.getForecast();
        forRequest.printOutGotInformation();
    }

}
