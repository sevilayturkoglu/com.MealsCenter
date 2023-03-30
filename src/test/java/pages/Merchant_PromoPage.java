package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Merchant_PromoPage {

    public Merchant_PromoPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    //Merchant >> Promo >> Coupon
    @FindBy(xpath = "(//li[.='Coupon'])[1]")
    public WebElement merchantPromoButton;

    //Merchant >> Promo >> Coupon >> Add New
    @FindBy(xpath = "//i[@class='zmdi zmdi-plus']")
    public WebElement promoAddNewButton;

    //Merchant >> Promo >> Coupon >> Add New >> Coupon Name
    @FindBy(xpath = "//label[@for='AR_voucher_voucher_name']")
    public WebElement promoCouponName;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon Type>>Percentage
    @FindBy(id = "AR_voucher_voucher_type")
    public WebElement promoCouponPercentage;

    //Merchant>> Promo>>Coupon>>Add New>>Days Available
    @FindBy(id = "AR_voucher_days_available")
    public WebElement promoCouponDaysAvailable;

    //Merchant>> Promo>>Coupon>>Add New>>Expiration
    @FindBy(xpath = "(//tbody//tr[6]/td[6])[1]")
    public WebElement promoCouponExpirationDate;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon Options
    @FindBy(xpath = "//select[@id='AR_voucher_used_once']")
    public WebElement promoCouponOptions;

    //Merchant>> Promo>>Coupon>>Add New>>Status
    @FindBy(xpath = "//select[@id='AR_voucher_status']")
    public WebElement promoCouponStatus;

    //Merchant >> Promo >> Coupon >> Add New >> Save Buton
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement promoCouponSaveButton;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List
    @FindBy(xpath = "//td//h6")
    public List<WebElement> allCouponList;

    @FindBy(xpath = "//li[@class='position-relative merchant_coupon active']")
    public WebElement allCuponMenuden;

    @FindBy(xpath = "//div[@class='breadcrumbs']")
    public WebElement updateAllCoupon;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>>Actions>>Delete
    @FindBy(xpath = "(//i[@class='zmdi zmdi-delete'])[1]")
    public WebElement promoFirstCouponDelete;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>>Actions>>Delete Confirmation
    @FindBy (xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement promoDeleteScript;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>>"Showing 1 to 4 of 4 entries" in the lower left corner
    @FindBy(xpath = "//div[@class='dataTables_info']")
    public WebElement couponEntryCount;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Update
    @FindBy(xpath = "(//i[@class='zmdi zmdi-border-color'])[1]")
    public WebElement promoCouponUpdate;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Update
    @FindBy(id ="AR_voucher_voucher_name")
    public WebElement promoCouponNameUpdate;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Name
    @FindBy(xpath = "//th[.='Name']")
    public WebElement isimListesi;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Used
    @FindBy(xpath = "//th[@aria-sort='descending']")
    public WebElement usedListesi;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> SearchBox
    @FindBy(xpath = "//input[@class='form-control rounded search w-25']")
    public WebElement searchbox;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> SearchBoxBuyutec
    @FindBy(xpath = "//i[@class='zmdi zmdi-search']")
    public WebElement searchBoxBuyutec;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> SearcBoxClose
    @FindBy(xpath = "//i[@class='zmdi zmdi-close']")
    public WebElement searcBoxClose;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Update>> Save>>Succesfully
    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement promoCouponSuccesfullyUpdate;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> Update>>AllCoupon
    @FindBy(xpath = "//a[.='All Coupon']")
    public WebElement promoCouponUpdateAllCoupon;

    //Merchant>> Promo>>Coupon>>Add New>>Coupon List>> All CouponUsed
    @FindBy (xpath ="//th[.='#Used']")
    public List<WebElement>promoAllUsedCoupunNo;

    //Dashboard >> Promo>>Coupon>> Add new (To create a new coupon)
    public void merchantCouponMake(String merchantCouponName) {

        promoAddNewButton.click();
        promoCouponName.click();
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(merchantCouponName).sendKeys(Keys.TAB).perform();

        Select select = new Select(promoCouponPercentage);
        select.selectByValue("fixed amount");
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("20").sendKeys(Keys.TAB).perform();

        ReusableMethods.bekle(2);
        Select select1 = new Select(promoCouponDaysAvailable);
        select1.selectByVisibleText("friday");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        promoCouponExpirationDate.click();
        actions.sendKeys(Keys.TAB).perform();


        Select select2 = new Select(promoCouponOptions);
        select2.selectByValue("2");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.bekle(2);
        Select select3 = new Select(promoCouponStatus);
        select3.selectByVisibleText("Publish");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        ReusableMethods.bekle(3);
        //promoCouponSaveButton.click();
        System.out.println(Driver.getDriver().findElement(By.xpath("//td//h6")).getText());
        List<String> merchantCouponList = new ArrayList<>();
        for (WebElement element : allCouponList) {
            merchantCouponList.add(element.getText());
        }
        System.out.println(merchantCouponList);
        ReusableMethods.bekle(1);
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertFalse(merchantCouponList.contains(merchantCouponName));

    }
    //Bu methodla bir onceki method ile olusturdugum kuponu siliyorum ve sildigimi assert ediyorum
    // ama assert islemini test sayfasinda yaptik
    //With this method, I delete the coupon I created with
    // the previous method and assert that I deleted it, but we did the assert on the test page.

    public void couponDelete() {

        promoFirstCouponDelete.click();
        ReusableMethods.bekle(1);
        promoDeleteScript.click();

    }
    // Bu methodla olusturulan kupon uzerinde degisiklik yapilabilir ve kaydedilebilir. Yeni hali ile Kupon Listesinde gorulur.
    // Changes can be made and saved on the coupon created with this method. It appears in the Coupon List in its new state.
    public void couponUpdate(){
        promoCouponUpdate.click();
        ReusableMethods.bekle(1);
        promoCouponNameUpdate.clear();
        ReusableMethods.bekle(1);
        promoCouponNameUpdate.sendKeys("Afiyetli Kupon !");
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).build().perform();
        ReusableMethods.bekle(1);
        promoCouponSaveButton.click();
        String actualUpdateText = promoCouponSuccesfullyUpdate.getText();
        String expectedUpdateText = "Succesfully updated";
        Assert.assertEquals(actualUpdateText,expectedUpdateText);
        ReusableMethods.bekle(1);
        //promoCouponUpdateAllCoupon.click();
        updateAllCoupon.click();
    }

    // Bu metod ile Isim Listesi Siralanir
    // Name List Sorted With This Method
    public void isimList(){
        List<String>allCoupon1 = new ArrayList<>();
        for (WebElement each : allCouponList){
            allCoupon1.add(each.getText());
        }
        ReusableMethods.bekle(2);
        isimListesi.click();
        ReusableMethods.bekle(1);

        List<String>allCoupon2= new ArrayList<>();
        for (WebElement each : allCouponList){
            allCoupon2.add(each.getText());
        }

        Assert.assertTrue(allCoupon1 != allCoupon2);
    }

    // Bu metod ile Used Listesi Siralanir
    //With this method, the Used List is Sorted
    public void usedList(){
        usedListesi.click();
        usedListesi.click();
        List<Integer>allUsedNo =new ArrayList<>();
        for (WebElement each : promoAllUsedCoupunNo){
            allUsedNo.add(Integer.parseInt(each.getText()));
        }
        ReusableMethods.bekle(1);
        for(int i= 0; i <allUsedNo.size()-1;i++){
            Assert.assertTrue(allUsedNo.get(i)>=allUsedNo.get(i+1));
        }
    }



}

