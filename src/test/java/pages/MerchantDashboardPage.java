package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class MerchantDashboardPage {

    public MerchantDashboardPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    //MerchantPage >> Dashboard Button
    @FindBy (xpath = "//li[@class='merchant_dashboard active']")
    public WebElement merchantDashboardButton;

    //MerchantPage >> Merchant >> MerchantBarMenu
    @FindBy (xpath = "(//*[@class='sidebar-nav-sub-menu'])[1]")
    public WebElement merchantBarMenu;

    //US029 Merchant page - order - completed
    @FindBy(xpath = "")
    public WebElement orderCompleted;






    //US019(Ali) MerchantPage >> Merchant >> Information
    @FindBy(xpath = "//a[.='Information']")
    public WebElement merchantMenuLeftInformation;

    //US019(Ali) MerchantPage >> Merchant >> Information >> Merchant Information
    @FindBy(xpath = "//a[.='Update Information']")
    public WebElement merchantInformationText;

    //US031(Ali) MerchantPage >> Merchant >> Orders >> All Orders
    @FindBy(xpath = "//a[@href='/backoffice/orders/history']")
    public WebElement merchantAllOrders;

    //US031(Ali) MerchantPage >> Merchant >> Orders >> All Orders >> Order history
    @FindBy(xpath = "//h5[.='Order history']")
    public WebElement merchantOrderHistoryText;


    //MerchantPage >> By changing "menuName" all Menus under Dashboard both click and display

    public void dashboardMenuListClick(String menuName){
        Driver.getDriver().findElement(By.xpath("//a[.='"+menuName+"']")).click();

        Driver.getDriver().findElement(By.xpath("//a[.='" + menuName + "']")).isDisplayed();
        }
    }








