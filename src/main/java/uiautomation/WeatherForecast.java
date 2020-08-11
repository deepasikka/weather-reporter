package main.java.uiautomation;

import main.java.constants.Constants;
import main.java.modal.Modal;
import main.java.pages.HomePage;
import main.java.pages.WeatherPage;
import main.java.utils.PropertyReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeatherForecast {
     Logger log = Logger.getLogger(WeatherForecast.class);
     WebDriver driver;
     Modal modal = new Modal();
     HomePage homePage;
     WeatherPage weatherPage;
     WebDriverWait wait;

    @BeforeClass
    public  void open_website() throws IOException {
        log.info("checking os");
        String pathToDriver = null;
        if(System.getProperty("os.name").toLowerCase().indexOf("win")>=0){
            pathToDriver = Constants.DRIVER_PATH_WINDOWS;
        }else if(System.getProperty("os.name").toLowerCase().indexOf("mac")>=0){
            pathToDriver = Constants.DRIVER_PATH_MAC;
        }
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        log.info("Initializing chrome browser");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        log.info("Maximizing browser");
        driver.get(Constants.UI_URL);
        log.info("Navigating to "+Constants.UI_URL);
        wait = new WebDriverWait(driver,5);
    }


    @Test
    public void get_weather()  {
        homePage = new HomePage(driver);
        weatherPage = new WeatherPage(driver);
        homePage.clickOnDotMenu();
        wait.until(ExpectedConditions.visibilityOf(homePage.weatherButton));
        homePage.clickOnWeatherButton();
        wait.until(ExpectedConditions.visibilityOf(weatherPage.searchBox));
        weatherPage.enterCityName(Constants.CITY);
        weatherPage.selectCity();
        wait.until(ExpectedConditions.visibilityOf(weatherPage.weatherInfoForCity));
        weatherPage.clickOnWeatherInfoForSelectedCity();
        List<WebElement> weatherInfo = weatherPage.getWeatherInfoList();
        for(int i=0; i<weatherInfo.size(); i++){
            String weather_parameter = weatherInfo.get(i).getText();
            if(weather_parameter.split(":")[0].equals("Humidity")){
                modal.setHumidity(weather_parameter.split(":")[1].trim());
                log.info("Getting humidity value ");
            }else
            if(weather_parameter.split(":")[0].equals("Temp in Degrees")){
                modal.setTemperature_degree(weather_parameter.split(":")[1].trim());
                log.info("Getting Temperature value in Degrees");
            }
        }
    }

    @AfterClass
    public  void closing_browser(){
        driver.quit();
        log.info("Closing Browser");
    }

    public Modal getModal(){
        return modal;
    }
}
