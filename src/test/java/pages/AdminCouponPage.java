package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class AdminCouponPage {
    public AdminCouponPage(){
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


    @FindBy(xpath = "//select[@id='AR_voucher_apply_to_merchant']")
    public WebElement applayToMerchantSelect;

    @FindBy(xpath = " (//tbody//tr[6]/td[6])[1]")
    public WebElement Expiration;

    @FindBy(id = "AR_voucher_used_once")
    public WebElement couponOption;

    @FindBy(id = "AR_voucher_status")
    public WebElement voucherstatus;

    @FindBy(xpath = "//td//h6")
    public List<WebElement> couponIsThereTest;

  /*  public void couponMake(String couponName) {
        couponAddButton.click();
        voucherName.click();

        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(couponName).sendKeys(Keys.TAB).perform();
        Select select=new Select(voucherTypeSelect);
        select.selectByValue("fixed amount");
        actions.sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("80").sendKeys(Keys.TAB).perform();

        Select select1=new Select(dayAvailibleSelect);
        select1.selectByVisibleText("tuesday");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        Expiration.click();
        actions.sendKeys(Keys.TAB).perform();
        Select select2=new Select(couponOption);
        ReusableMethods.bekle(1);
        select2.selectByValue("3");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.PAGE_DOWN).perform();
        Select select3=new Select(voucherstatus);
        select3.selectByVisibleText("Pending for review");
        ReusableMethods.bekle(1);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();



        List<String> couponList=new ArrayList<>();
        for (WebElement element : couponIsThereTest) {
            couponList.add(element.getText());
            System.out.println(element.getText());
        }
        System.out.println(couponList);
        System.out.println(couponName + " Pending for review");
        Assert.assertTrue(couponList.contains(couponName + " Pending for review"));


    }*/
}
