package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
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

    @FindBy(css = "div[class='rounded-status-report rounded r1'] h5")
    public WebElement totalSales;

    @FindBy(css = "div[class='rounded-status-report rounded r2'] h5")
    public WebElement totalMerchant;

    @FindBy(css = "div[class='rounded-status-report rounded r3'] h5")
    public WebElement totalCommission;

    @FindBy(css = "div[class='rounded-status-report rounded r4'] h5")
    public WebElement totalSubscription;

    @FindBy(xpath = "//h6[normalize-space()='Commission this week']")
    public WebElement comissionThisWeek;

    @FindBy(xpath = "//h6[normalize-space()='Commission this month']")
    public WebElement comissionThisMonth;

    @FindBy(xpath = "//h6[normalize-space()='Subscriptions this month']")
    public WebElement subscriptionsThisMonth;

    @FindBy(xpath = "//h5[normalize-space()='Order received']")
    public WebElement orderReceived;

    @FindBy(xpath = "//h5[normalize-space()='Today delivered']")
    public WebElement todayDelivered;

    @FindBy(xpath = "//h5[normalize-space()='New customer']")
    public WebElement newCustomer;

    @FindBy(xpath = "//h5[normalize-space()='Total refund']")
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
    @FindBy(xpath = "//*[.='List']")
    public WebElement listlink;
    @FindBy(xpath = "(//*[.='All Merchant'])[2]")
    public WebElement allMerchantText;
    @FindBy(xpath = "(//*[@class='sorting_1'])[2]")
    public WebElement merchantFromAllMerchant;

    @FindBy(xpath = "(//*[@data-original-title='Auto Login'])[1]")
    public WebElement autoLoginButton;
    @FindBy(xpath = "(//*[@class='btn btn-light tool_tips'])[1]")
    public WebElement editMerchantButton;
    @FindBy(id = "AR_merchant_restaurant_name")
    public WebElement restaurantNameBox;
    @FindBy(id = "AR_merchant_restaurant_slug")
    public WebElement restaurantSlugBox;
    @FindBy(id = "AR_merchant_contact_name")
    public WebElement contactNameBox;
    @FindBy(id = "AR_merchant_contact_phone")
    public WebElement contactPhoneBox;
    @FindBy(id = "AR_merchant_contact_email")
    public WebElement contactEmailBox;
    @FindBy(xpath = "//*[@class='note-editable card-block']")
    public WebElement aboutBox;
    @FindBy(xpath = "//*[@class='form-control form-control-text textarea_min']")
    public WebElement shortAboutBox;
    @FindBy(xpath = "(//*[@class='selection'])[1]")
    public WebElement cuisineBox;
    @FindBy(xpath = "(//*[.='Burgers'])[2]")
    public WebElement BurgersLink;
    @FindBy(xpath = "(//*[@class='selection'])[2]")
    public WebElement servicesBox;
    @FindBy(xpath = "(//*[.='Pickup'])[2]")
    public WebElement pickupLink;
    @FindBy(xpath = "(//*[@class='selection'])[3]")
    public WebElement tagsBox;
    @FindBy(xpath = "(//*[@class='selection'])[4]")
    public WebElement featuredBox;
    @FindBy(xpath = "(//*[.='Popular'])[1]")
    public WebElement popularLink;
    @FindBy(id = "AR_merchant_delivery_distance_covered")
    public WebElement deliveryDistanceBox;
    @FindBy(id = "AR_merchant_status")
    public WebElement statusBox;
    @FindBy(xpath = "//*[@value='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement succesfullyUptadeText;

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






        //Earnings


    //Promo



        //Promo


        //Buyers


        //Records


        //Media Library

        //Admin Login Method
    } public void adminLoginOl() {
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        adminUserName.sendKeys(ConfigReader.getProperty("adminSevilay"));
        adminPassword.sendKeys("123456");
        adminSignIn.click();
    }
    //Buyers *** Methods


}
