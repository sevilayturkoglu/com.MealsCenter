package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

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


    @FindBy(xpath = "(//a[@href='javascript:;'])[2]")
    public WebElement ordersLink;
    @FindBy(xpath = "//li[@class='position-relative order_list']")
    public WebElement allOrderLink;
    @FindBy(xpath = "(//*[text()='All Orders'])[2]")
    public WebElement allOrdersText;
    @FindBy(xpath = "(//*[text()='Orders'])[2]")
    public WebElement ordersText;
    @FindBy(xpath = "//p[text()='Cancel']")
    public WebElement cancelText;

    @FindBy(xpath = "//*[text()='Total refund']")
    public WebElement totalRefundText;
    @FindBy(xpath = "//*[text()='Total Orders']")
    public WebElement totalOrdersText;


    @FindBy(xpath = "(//*[text()='Filters'])[1]")
    public WebElement orderFiltersButton;
    @FindBy(xpath = "(//*[@aria-label='Order ID: activate to sort column ascending'])[1]")
    public WebElement orderOrderId;
    @FindBy(xpath = "(//*[@class='zmdi zmdi-eye'])[1]")
    public WebElement orderViewSign;
    @FindBy(xpath = "(//*[@class='zmdi zmdi-download'])[1]")
    public WebElement orderDownloadSign;
    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    public WebElement orderFiltersBody;


    //This method is used to list  the items in the customer product categories.
    public List<Integer> orderIdElementsMethod() {
        //   //tbody/tr[3]/td[5]======>3.satir,  5.sutun


        List<Integer> idElementsInt = new ArrayList<>();
        String idElements = "";
        for (int i = 1; i <= 10; i++) {
            ReusableMethods.bekle(3);
            idElements = Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText();
            idElementsInt.add(Integer.parseInt(idElements));

        }
        return idElementsInt;

        }


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
