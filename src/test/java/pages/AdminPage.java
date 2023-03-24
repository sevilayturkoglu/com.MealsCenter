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

    @FindBy(xpath = "(//div[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0'])[1]")
    public WebElement totalSales;

    @FindBy(xpath = "(//div[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0'])[2]")
    public WebElement totalMerchant;

    @FindBy(xpath = "(//div[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0'])[3]")
    public WebElement totalCommission;

    @FindBy(xpath = "(//div[@class='col p-0 col-lg-3 col-md-3 col-sm-6 col-6 mb-3 mb-xl-0'])[4]")
    public WebElement totalSubscription;

    @FindBy(xpath = "(//div[@class='card'])[1]")
    public WebElement comissionThisWeek;

    @FindBy(xpath = "(//div[@class='card'])[2]")
    public WebElement comissionThisMonth;

    @FindBy(xpath = "(//div[@class='card'])[3]")
    public WebElement subscriptionsThisMonth;

    @FindBy(xpath = "(//div[@class='col mb-2 mb-xl-0'])[1]")
    public WebElement orderReceived;

    @FindBy(xpath = "(//div[@class='col mb-2 mb-xl-0'])[2]")
    public WebElement todayDelivered;

    @FindBy(xpath = "(//div[@class='col mb-2 mb-xl-0'])[3]")
    public WebElement newCustomer;

    @FindBy(xpath = "(//div[@class='col mb-2 mb-xl-0'])[4]")
    public WebElement totalRefund;

    @FindBy(xpath = "(//h5[@class='m-0'])[1]")
    public WebElement lastOrders;

    @FindBy(xpath = "(//h5[@class='m-0'])[2]")
    public WebElement popularItems;

    @FindBy(xpath = "(//h5[@class='m-0'])[3]")
    public WebElement popularMerchants;

    @FindBy(xpath = "(//h5[@class='m-0 mb-3'])[1]")
    public WebElement salesOverview;

    @FindBy(xpath = "(//h5[@class='m-0 mb-3'])[2]")
    public WebElement topCustomers;

    @FindBy(xpath = "(//h5[@class='m-0 mb-3'])[3]")
    public WebElement overviewOfReviev;

    @FindBy(xpath = "(//h5[@class='m-0 mb-3'])[4]")
    public WebElement recentPayout;





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
