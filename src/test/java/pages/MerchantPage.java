package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "(//*[@class='d-block chevron-section promo-section d-flex align-items-center rounded mb-2'])[3]")
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

    @FindBy(xpath = "(//img)[18]")
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

    @FindBy(xpath = "(//*[@class='ref_delete normal btn btn-light tool_tips'])[1]")
    public WebElement deleteItemButton;

    // ========= Nesibe =============

    @FindBy(xpath = "//a[@class='dim underline']")
    public WebElement forgotPassword;

    @FindBy(id = "AR_merchant_login_email_address")
    public WebElement merchantEmailAddress;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement requestEmailbutton;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement requestedMail;

    @FindBy(xpath = "//*[text()='Email address not found']")
    public WebElement mailErrorMessage1;

    @FindBy(xpath = "//*[text()='Email Address is not a valid email address.']")
    public WebElement mailErrormessage2;

    @FindBy(xpath = "//*[text()='Attributes']")
    public WebElement attributes;

    @FindBy(xpath = "//*[text()='Size']")
    public WebElement size;

    @FindBy(xpath = "//*[text()='Ingredients']")
    public WebElement ingredients;

    @FindBy(xpath = "//*[text()='Cooking Reference ']")
    public WebElement cookingref;

    @FindBy(xpath = "//a[@type='button']")
    public WebElement plusSymbol;


    @FindBy(xpath = "//div[@class='p-2']")
    public WebElement itemTranslation;

    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[2]")
    public WebElement japaneseTranslation;

    @FindBy(xpath = "(//input[@class='form-control form-control-text'])[3]")
    public WebElement arabicTranslation;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement attSaveButton;

    @FindBy(xpath = "//select[@class='form-control custom-select form-control-select']")
    public WebElement statusElementleri;

    @FindBy(xpath = "//option[@value='draft']")
    public WebElement draft;

    @FindBy(xpath = "//option[@value='pending']")
    public WebElement pending;

    @FindBy(xpath = "//option[@value='publish']")
    public WebElement publish;

    @FindBy(xpath = "(//a[@class='btn btn-light tool_tips'])[1]")
    public WebElement updateButonu1;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement updated;

    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement notUpdated;

    @FindBy(xpath = "(//a[@class='btn btn-light datatables_delete tool_tips'])[1]")
    public WebElement deleteButton1;

    @FindBy(xpath = "//h5[text()='Delete Confirmation']")
    public WebElement deleteConfirmationMessage;

    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement deleteConfirmButton;

    @FindBy(xpath = "(//tr/th)[1]")
    public WebElement sortingNumber;

    @FindBy(xpath = "(//tr/th)[2]")
    public WebElement sortingName;

    @FindBy(xpath = "(//tr/th)[3]")
    public WebElement sortingAction;

    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> sortingNumberList;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> sortingNameList;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[@type='submit'])[3]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id='AR_ingredients_ingredients_name']")
    public WebElement ingredientsNameElementi;

    @FindBy(xpath = "//*[@id='AR_cookingref_cooking_name']")
    public WebElement cookingrefNameElementi;

    @FindBy(xpath = "//*[@id='AR_size_size_name']")
    public WebElement sizeNameElementi;




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

    public void MerchantPageLoginSry(){
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        MerchantPage merchantPage = new MerchantPage();
        merchantPage.merchantUserName.sendKeys(ConfigReader.getProperty("subwayUsername"));
        ReusableMethods.bekle(1);
        merchantPage.merchantUserPassword.sendKeys(ConfigReader.getProperty("subwayPassword"));
        merchantPage.merchantSignIn.click();

    }

    public void sortForNumber() {
        sortingNumber.click();
        ReusableMethods.bekle(2);
        List<Integer> numaralar = new ArrayList<>();
        for (WebElement each : sortingNumberList) {
            numaralar.add(Integer.parseInt(each.getText()));
        }
        ReusableMethods.bekle(1);

        for (int i = 0; i < numaralar.size() - 1; i++) {
            if (numaralar.get(i) <= numaralar.get(i + 1)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    public void sortForName() {
        sortingName.click();
        ReusableMethods.bekle(2);
        List<String> names = new ArrayList<>();
        for (WebElement each : sortingNameList) {
            names.add(each.getText().substring(0, 1).toLowerCase());
        }
        ReusableMethods.bekle(1);

        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).charAt(0) <= names.get(i + 1).charAt(0)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }

        }

        System.out.println(names);
    }

    public void sortFoActions() {
        sortingAction.click();
        ReusableMethods.bekle(2);
        List<Integer> numaralar = new ArrayList<>();
        for (WebElement each : sortingNumberList) {
            numaralar.add(Integer.parseInt(each.getText()));
        }
        ReusableMethods.bekle(1);

        for (int i = 0; i < numaralar.size() - 1; i++) {
            if (numaralar.get(i) <= numaralar.get(i + 1)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }
}