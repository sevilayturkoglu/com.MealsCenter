package tests.US_013_025_037;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

public class US_013 extends TestBaseReport {

    UserPage userPage = new UserPage();
    SoftAssert softAssert = new SoftAssert();
    MerchantPage merchantPage = new MerchantPage();


    @Test(priority = 1)
    public void productAddtoCartTest(){
        extentTest = extentReports.createTest("productAddtoCartTest","A product must be able to be added to \n" +
                "the cart" );
        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        String expectedProductText = "Oven-Roasted Turkey";
        String actualProductText = merchantPage.cartText.getText();
        softAssert.assertEquals(actualProductText,expectedProductText);
        extentTest.pass("Verified  that the product appears on the cart");
        softAssert.assertAll();

    }
    @Test(priority = 15)
    public void paymentTest(){
        extentTest = extentReports.createTest("paymentTest"," the payment must be able to be made");
        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        ReusableMethods.bekle(2);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.cashOnDeliveryLink);
        extentTest.info("Cash On delivery link is clicked");
        merchantPage.addCashButton.click();
        extentTest.info("Add cash button is clicked");
        String expectedPaymentMethodText = "Default";
        String actualPaymentMethodText = merchantPage.paymentMethodDefault.getText();
        softAssert.assertTrue(actualPaymentMethodText.contains(expectedPaymentMethodText));
       Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        Driver.getDriver().findElement(By.xpath("(//a[@id='dropdownMenuLink'])[1]")).click();
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//a[.='Delete'])[1]")).click();
        ReusableMethods.bekle(2);
        extentTest.pass("Verified  that Cash On delivery is default");
        softAssert.assertAll();

    }
    @Test(priority = 20)
    public void addressTest(){
        extentTest = extentReports.createTest("addressTest"," An address must be able to be entered");
        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        ReusableMethods.bekle(2);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.addNewAddressLink);
        extentTest.info("Add new address link is clicked");
        merchantPage.enterDeliveryAddressBox.sendKeys("11");
        extentTest.info("Entered new address");
        ReusableMethods.waitForVisibility(userPage.userChooseAddres,10);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.addNewAddressLink);
        merchantPage.newSelectedAddress.click();
        extentTest.info("Clicked new address");
        merchantPage.newAddressSaveButton.click();
        extentTest.info("New address save button is clicked");
        JSUtilities.scrollToElement(Driver.getDriver(), merchantPage.savedAddressBox);
        String expectedNewAddressText = "11 Howard";
        String actualNewAddressText = merchantPage.savedAddressBox.getText();
        softAssert.assertTrue(actualNewAddressText.contains(expectedNewAddressText));
        ReusableMethods.bekle(2);
        extentTest.pass("Verified that address is entered");
        softAssert.assertAll();

    }
    @Test(priority = 30)
    public void availableToPurchaseTest(){
        extentTest = extentReports.createTest("availableToPurchaseTest"," the product is available for purchase");
        userPage = new UserPage();
        userPage.userLoginBeing();
        extentTest.info("User signed in");
        ReusableMethods.bekle(2);
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.merchantSubwayLink);
        extentTest.info("Subway link is clicked");
        merchantPage.addToCartButton.click();
        extentTest.info("Add to cart link is clicked");
        merchantPage.checkoutButton.click();
        extentTest.info("Checkout link is clicked");
        JSUtilities.clickWithJS(Driver.getDriver(),merchantPage.cashOnDeliveryLink);
        extentTest.info("Cash On delivery link is clicked");

        merchantPage.addCashButton.click();
        extentTest.info("Add cash button is clicked");
        softAssert.assertTrue(merchantPage.placeOrderButton.isDisplayed());
        extentTest.pass("Verified that the product is available for purchase");
        ReusableMethods.bekle(2);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(3);
        Driver.getDriver().findElement(By.xpath("(//a[@id='dropdownMenuLink'])[1]")).click();
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("(//a[.='Delete'])[1]")).click();
        ReusableMethods.bekle(2);
        softAssert.assertAll();

    }
}
