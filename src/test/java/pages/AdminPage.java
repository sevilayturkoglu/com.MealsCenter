package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class AdminPage {
    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Admin login locators  https://qa.mealscenter.com/account/login
    @FindBy(id = "LoginForm_username")
    public WebElement adminUserName;
    @FindBy(id = "LoginForm_password")
    public WebElement adminPassword;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement adminSignIn;


    //Merchant





    //Orders





    //Earnings




    //Promo




    //Buyers




    //Records




    //Media Library

    //Admin Login Method
    public void adminLoginOl() {
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        adminUserName.sendKeys(ConfigReader.getProperty("adminSevilay"));
        adminPassword.sendKeys("123456");
        adminSignIn.click();
    }
    //Buyers *** Methods


}
