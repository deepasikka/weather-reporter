package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "h_sub_menu")
    public WebElement dotMenu;

    @FindBy(xpath = "//a[contains(text(),\"WEATHER\")]")
    public WebElement weatherButton;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnDotMenu(){
        dotMenu.click();
    }

    public void clickOnWeatherButton(){
        weatherButton.click();
    }
}
