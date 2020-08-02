package main.java.uiautomation;

import com.sun.org.apache.bcel.internal.Const;
import main.java.constants.Constants;
import main.java.modal.UIModal;
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

    static WebDriver driver;
    static UIModal modal = new UIModal();
    @BeforeClass
    public static void open_website(){

        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get(Constants.UI_URL);
    }

    @Test
    public static void open_weather_section(){
        driver.findElement(By.id("h_sub_menu")).click();
        driver.findElement(By.linkText("WEATHER")).click();
        driver.findElement(By.id("searchBox")).sendKeys(Constants.CITY);
        driver.findElement(By.id("Chandigarh")).click();
        driver.findElement(By.xpath("//div[@class='outerContainer' and @title='Chandigarh']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//span[@class='heading']"));
        for(int i=0; i<list.size(); i++){
            String weather_parameter = list.get(i).getText();

            if(weather_parameter.split(":")[0].equals("Condition ")){
                modal.setCondition(weather_parameter.split(":")[1].trim());
            }else
            if(weather_parameter.split(":")[0].equals("Wind")){
                modal.setWind(weather_parameter.split(":")[1].trim());
            }else
            if(weather_parameter.split(":")[0].equals("Humidity")){
                modal.setHumidity(weather_parameter.split(":")[1].trim());
            }else
            if(weather_parameter.split(":")[0].equals("Temp in Degrees")){
                modal.setTemperature_degree(weather_parameter.split(":")[1].trim());
            }else
            if(weather_parameter.split(":")[0].equals("Temp in Fahrenheit")){
                modal.setTemperature_fah(weather_parameter.split(":")[1].trim());
            }

        }
        System.out.println(modal.toString());
    }

    @AfterClass
    public static void closing_browser(){
        driver.quit();
    }
}
