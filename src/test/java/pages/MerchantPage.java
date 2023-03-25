package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class MerchantPage {
    public MerchantPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
//Merchant login locators
    @FindBy(id = "AR_merchant_login_username")
    public WebElement merchantUserName;
    @FindBy(id = "AR_merchant_login_password")
    public WebElement merchantUserPassword;
    @FindBy(xpath= "//input[@type='submit']")
    public WebElement merchantSignIn;

    //Merchant SubWay locators
    @FindBy(xpath = "(//h6[.='Subway'])[1]")
    public WebElement merchantSubwayLink;

    @FindBy(xpath = "(//a[@class='btn btn-grey quantity-add-cart'])[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='mb-1']")
    public WebElement cartText;

    //Bu method sizi merchant sayfasina login yapacak
    //restaurantName olarak configuration.propertiesdekini restaurant adini kullanin
    public void merchantLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        merchantUserName.sendKeys(ConfigReader.getProperty("subway"));
        ReusableMethods.bekle(1);
        merchantUserPassword.sendKeys(ConfigReader.getProperty("merchantPassword"));
        merchantSignIn.click();
    }


//Bu method dashboard haric merchant anasayfada solda bulunan menuye gidecek siz icine gitmek
// istediginiz menunun adini yazacaksiniz Or:  Merchant  , Orders , Food , Attributes .. gibi
    public void merchantMenuLeftSide(String menuName) {
        Driver.getDriver().findElement(By.xpath("//a[.='" + menuName + "']")).click();
    }
}