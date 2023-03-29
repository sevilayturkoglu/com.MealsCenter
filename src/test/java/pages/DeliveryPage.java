package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeliveryPage {
    public DeliveryPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='javascript:;'])[7]")
    public WebElement orderType;

    @FindBy(xpath = "//a[.='Delivery']")
    public WebElement delivery;

    @FindBy(xpath = "(//i[@class='zmdi zmdi-settings'])[1]")
    public WebElement setting;





    @FindBy(xpath ="(//label[@class='custom-control-label'])[1]")
    public WebElement noContactDelivery;

    @FindBy(xpath ="(//label[@class='custom-control-label'])[2]")
    public WebElement freeOnFirstOrder;

    @FindBy(xpath = "//select[@id='AR_option_merchant_delivery_charges_type']")
    public WebElement deliveryChargeTypeDDM;

    @FindBy(xpath ="//div[@class='form-label-group'])[2]")
    public WebElement serviceFee;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement settingSave;


    @FindBy(xpath = "(//li[@class='fixed_charge active'])[1]")
    public WebElement fixedCharge;



    @FindBy(xpath ="//input[@id='AR_shipping_rate_distance_price']")
    public WebElement price;

    @FindBy(xpath = "//label[text()='Delivery estimation']")
    public WebElement deliveryEstimation;

    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[2]")
    public WebElement minimumOrder;

    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[3]")
    public WebElement maximumOrder;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement save;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement settingsSaved;









}
