package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

    @FindBy(id = "//ul[@id='yw0']")
    public WebElement daschboardMenuHepsi;

    public void merchantMenuList(String menuName){
        Driver.getDriver().findElement(By.xpath("//a[.='"+menuName+"']")).click();

    }
    public void DashboardMenuListClick(String menuName){
        Driver.getDriver().findElement(By.xpath("//a[.='"+menuName+"']")).click();

        Driver.getDriver().findElement(By.xpath("//a[.='" + menuName + "']")).isDisplayed();


        }
    }








