package main.java.pages;

import main.java.constants.Constants;
import main.java.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class WeatherPage {

    WebDriver driver;

    @FindBy(id = "searchBox")
    public WebElement searchBox;

    @FindBy(id= "Chandigarh")
    public WebElement city;

    @FindBy(xpath = "//div[@class='outerContainer' and @title='Chandigarh']")
    public WebElement weatherInfoForCity;

    @FindBy(xpath = "//span[@class='heading']")
    public List<WebElement> weatherInfoList;


    public WeatherPage(WebDriver driver)  {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    public void enterCityName(String city){

        searchBox.sendKeys(city);
    }
    public void selectCity(){
        city.click();
    }
    public void clickOnWeatherInfoForSelectedCity(){
        weatherInfoForCity.click();

    }
    public List<WebElement> getWeatherInfoList(){
        return weatherInfoList;
    }
}
