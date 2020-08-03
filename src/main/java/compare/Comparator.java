package main.java.compare;

import main.java.api.APIWeatherForecast;
import main.java.constants.Constants;
import main.java.uiautomation.WeatherForecast;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Comparator {
    static Logger log = Logger.getLogger(Comparator.class);
    WeatherForecast weatherForecast = new WeatherForecast();
    APIWeatherForecast apiWeatherForecast = new APIWeatherForecast();
    @Test
    public void compareTempInDeg(){
        log.info("Max Temp variance is :"+Constants.VARIANCE_IN_TEMP);
        double tempInDegFromUI =  Double.parseDouble(weatherForecast.getModal().getTemperature_degree());
        double tempInDegFromAPI = Double.parseDouble(apiWeatherForecast.getModal().getTemperature_degree());
        double variance = tempInDegFromAPI-tempInDegFromUI;
        variance=Math.abs(variance);
        log.info("Calculating variance in Temp :"+ variance);
        Assert.assertTrue(variance <= Constants.VARIANCE_IN_TEMP);

    }
    @Test
    public void compareHumidity(){
        log.info("Max Humidity variance is :"+Constants.VARIANCE_IN_HUMIDITY);

        double humidityFromUI = Double.parseDouble(weatherForecast.getModal().getHumidity().substring(0, weatherForecast.getModal().getHumidity().length()-1));
        double humidityFromAPI = Double.parseDouble(apiWeatherForecast.getModal().getHumidity());
        double variance = humidityFromAPI-humidityFromUI;
        variance=Math.abs(variance);
        log.info("Calculating variance in Humidity :"+ variance);

        Assert.assertTrue(variance <= Constants.VARIANCE_IN_HUMIDITY);

    }

}
