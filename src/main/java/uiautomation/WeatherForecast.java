package main.java.uiautomation;

import main.java.constants.Constants;
import main.java.modal.Modal;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeatherForecast {
    static Logger log = Logger.getLogger(WeatherForecast.class);
    static WebDriver driver;
    static Modal modal = new Modal();
    @BeforeClass
    public static void open_website(){

        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        log.info("Initializing chrome browser");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        log.info("Maximizing browser");
        driver.get(Constants.UI_URL);
        log.info("Navigating to "+Constants.UI_URL);
    }

    @Test
    public static void open_weather_section(){
        driver.findElement(By.id("h_sub_menu")).click();
        log.info("Clicking on 3 dot menu");
        driver.findElement(By.linkText("WEATHER")).click();
        log.info("Clicking on weather");
        driver.findElement(By.id("searchBox")).sendKeys(Constants.CITY);
        log.info("Searching for "+Constants.CITY);
        driver.findElement(By.id("Chandigarh")).click();
        driver.findElement(By.xpath("//div[@class='outerContainer' and @title='Chandigarh']")).click();
        log.info("Fetching all weather details for "+Constants.CITY);
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='heading']"));
        for(int i=0; i<list.size(); i++){
            String weather_parameter = list.get(i).getText();

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
    public static void closing_browser(){
        driver.quit();
        log.info("Closing Browser");
    }

    public Modal getModal(){
        return modal;
    }
}
