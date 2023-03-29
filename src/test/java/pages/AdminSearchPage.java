package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminSearchPage {
    public AdminSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[.='Promo']")
    public WebElement promoButton;

    @FindBy(xpath = "//a[.='Coupon']")
    public WebElement couponButton;

    @FindBy(xpath = "//label[@for='AR_voucher_voucher_name']")
    public WebElement voucherName;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchbox;


    public void couponSearch(String Searcbox) {
        searchbox.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(voucherName).sendKeys(Keys.ENTER).perform();

    }
}
