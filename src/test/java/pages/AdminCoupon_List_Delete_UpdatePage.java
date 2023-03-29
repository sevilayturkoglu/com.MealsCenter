package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AdminCoupon_List_Delete_UpdatePage {
    public AdminCoupon_List_Delete_UpdatePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[.='Promo']")
    public WebElement promoButton;

    @FindBy(xpath = "//a[.='Coupon']")
    public WebElement couponButton;
    @FindBy(xpath = "//i[@class='zmdi zmdi-plus']")
    public WebElement couponAddButton;

    @FindBy(xpath = "//label[@for='AR_voucher_voucher_name']")
    public WebElement voucherName;

    @FindBy(id = "AR_voucher_voucher_type")
    public WebElement voucherTypeSelect;

    @FindBy(id = "AR_voucher_days_available")
    public WebElement dayAvailibleSelect;

    @FindBy(xpath = " (//tbody//tr[6]/td[6])[1]")
    public WebElement Expiration;

    @FindBy(id = "AR_voucher_used_once")
    public WebElement couponOption;

    @FindBy(id = "AR_voucher_status")
    public WebElement voucherstatus;

    @FindBy(xpath = "//td//h6")
    public List<WebElement> allCoupons;

    @FindBy(xpath = "(//a[@class='btn btn-light datatables_delete tool_tips'])   ")
    public WebElement firstCouponDelete;

    @FindBy(xpath = "//a[@class='btn btn-green item_delete']")
    public WebElement deleteScript;

    @FindBy(xpath = "//div[@class='dataTables_info']")
    public WebElement enteryCount;

    @FindBy(xpath = " (//i[@class='zmdi zmdi-border-color'])[1]")
    public WebElement updateButton;

    @FindBy(id = "AR_voucher_voucher_name")
    public WebElement couponNameClean;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement succsesfulyUpdateText;

    @FindBy(xpath = "//input[@value='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//th[.='Name']")
    public WebElement sortName;

    @FindBy(xpath = "(//th[@aria-controls='DataTables_Table_0'])[3]")
    public WebElement usedCount;

    @FindBy(xpath = " //tbody/tr/td[3]")
    public List<WebElement> allUsedCouponNumber;


    public void couponMake(String couponName) {
//Bu method ile kupon ekliyorum ,kuponun orada sayfada goruldugunu dogruluyorum
        couponAddButton.click();
        voucherName.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(couponName).sendKeys(Keys.TAB).perform();
        Select select = new Select(voucherTypeSelect);
        select.selectByValue("fixed amount");
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("80").sendKeys(Keys.TAB).perform();

        Select select1 = new Select(dayAvailibleSelect);
        select1.selectByVisibleText("tuesday");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        Expiration.click();
        actions.sendKeys(Keys.TAB).perform();
        Select select2 = new Select(couponOption);
        ReusableMethods.bekle(1);
        select2.selectByValue("3");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        Select select3 = new Select(voucherstatus);
        select3.selectByVisibleText("Pending for review");
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


        List<String> couponList = new ArrayList<>();
        for (WebElement element : allCoupons) {
            couponList.add(element.getText());
        }
        Assert.assertTrue(couponList.contains(couponName + " Pending for review"));
        ReusableMethods.bekle(1);


    }

    //Bu methodla bir onceki method ile olusturdugum kuponu siliyorum ve sildigimi assert ediyorum ama assert islemini test sayfasinda yaptik
    public void couponDelete() {

        firstCouponDelete.click();
        ReusableMethods.bekle(1);
        deleteScript.click();
    }

    public void updateCoupon() {
        // bu methodla update etmek icin yeni kupon olusturacagiz ve kuponu update ettigimizi assert edecegiz
        updateButton.click();
        couponNameClean.clear();
        couponNameClean.sendKeys("Yeni coupon name");
        ReusableMethods.bekle(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        saveButton.click();
        String actualUpdateText = succsesfulyUpdateText.getText();
        String expectedUpdateText = "Succesfully updated";
        Assert.assertEquals(actualUpdateText, expectedUpdateText);
        ReusableMethods.bekle(1);
        couponButton.click();



    }

    public void sortName() {
        List<String> allCoupon1 = new ArrayList<>();
        for (WebElement each : allCoupons) {
            allCoupon1.add(each.getText());
        }
        ReusableMethods.bekle(2);
        sortName.click();
        ReusableMethods.bekle(2);

        List<String> allCoupon2 = new ArrayList<>();
        for (WebElement each : allCoupons) {

            allCoupon2.add(each.getText());
        }


        Assert.assertTrue(allCoupon1 != allCoupon2);
    }

    public void usedCoupon() {
        usedCount.click();
        usedCount.click();
        ReusableMethods.bekle(2);
        List<Integer> allNumber = new ArrayList<>();
        for (WebElement each : allUsedCouponNumber) {
            allNumber.add(Integer.parseInt(each.getText()));
        }
        for (int i = 0; i <allNumber.size()-1 ; i++) {
            Assert.assertTrue( allNumber.get(i)>=allNumber.get(i+1));
        }

    }
}
