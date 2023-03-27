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

    //Merchant SubWay locators(Eyup)
    @FindBy(xpath = "(//h6[.='Subway'])[1]")
    public WebElement merchantSubwayLink;

    @FindBy(xpath = "(//a[@class='btn btn-grey quantity-add-cart'])[1]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[.='Checkout']")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='mb-1']")
    public WebElement cartText;


    @FindBy(xpath = "//*[.='Cash On delivery']")
    public WebElement cashOnDeliveryLink;

    @FindBy(xpath = "//*[.='Add Cash']")
    public WebElement addCashButton;

    @FindBy(xpath = "//*[.='Default']")
    public WebElement paymentMethodDefault;

    @FindBy(xpath = "//*[.='Add new address']")
    public WebElement addNewAddressLink;

    @FindBy(xpath = "//*[@placeholder='Enter delivery address']")
    public WebElement enterDeliveryAddressBox;

    @FindBy(xpath = "(//*[.='Save'])[10]")
    public WebElement newAddressSaveButton;

    @FindBy(xpath = "(//*[@class='m-0 text-grey'])[5]")
    public WebElement newSelectedAddress;

    @FindBy(xpath = "//*[@class='bold mr-1']")
    public WebElement savedAddressBox;

    @FindBy(xpath = "//*[.='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//*[@class='dropdown show']")
    public WebElement cashOnDeliveryDefaultButton;

    @FindBy(xpath = "(//*[.='Delete'])[2]")
    public WebElement cashOnDeliveryDefaultButtonDelete;

    @FindBy(xpath = "//*[.='Items']")
    public WebElement itemLink;

    @FindBy(xpath = "(//*[.='Item list'])[2]")
    public WebElement itemListText;

    @FindBy(xpath = "(//*[@type='button'])[4]")
    public WebElement addNewProductButton;

    @FindBy(xpath = "//*[@id='AR_item_item_name']")
    public WebElement newItemNameBox;

    @FindBy(xpath = "//*[@id='AR_item_item_short_description']")
    public WebElement shortDescriptionBox;

    @FindBy(xpath = "//*[@class='note-editable card-block']")
    public WebElement longDescriptionBox;

    @FindBy(xpath = "//*[@id='AR_item_item_price']")
    public WebElement itemPriceBox;

    @FindBy(xpath = "//*[@id='AR_item_item_unit']")
    public WebElement selectUnitBox;

    @FindBy(xpath = "//*[@id='AR_item_category_selected']")
    public WebElement selectCategoryBox;

    @FindBy(xpath = "(//*[.='Browse'])[2]")
    public WebElement browseButtton;

    @FindBy(xpath = "(//img)[5]")
    public WebElement selectFileFromBrowse;

    @FindBy(xpath = "(//*[.='Add Files'])[2]")
    public WebElement addFilesButtton;

    @FindBy(xpath = "(//*[@class='selection'])[2]")
    public WebElement selectFeaturedBox;

    @FindBy(xpath = "(//*[.='Trending'])[2]")
    public WebElement selectTrendingFromFeaturedBox;

    @FindBy(xpath = "//*[@id='AR_item_color_hex']")
    public WebElement backgroundColorHexBox;

    @FindBy(xpath = "(//*[@class='sp-thumb-el sp-thumb-dark'])[9]")
    public WebElement backgroundColorButton;

    @FindBy(xpath = "//*[.='choose']")
    public WebElement backgroundColorChoose;

    @FindBy(xpath = "//*[@id='AR_item_status']")
    public WebElement selectStatusBox;

    @FindBy(xpath = "//*[@value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement succesfullyCreatedText;


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